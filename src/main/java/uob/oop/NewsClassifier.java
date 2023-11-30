package uob.oop;

import java.text.DecimalFormat;


public class NewsClassifier {

    public String[] myHTMLs;
    public String[] myStopWords = new String[127];
    public String[] newsTitles;
    public String[] newsContents;
    public String[] newsCleanedContent;
    public double[][] newsTFIDF;

    private final String TITLE_GROUP1 = "Osiris-Rex's sample from asteroid Bennu will reveal secrets of our solar system";
    private final String TITLE_GROUP2 = "Bitcoin slides to five-month low amid wider sell-off";

    public Toolkit myTK;

    public NewsClassifier() {
        myTK = new Toolkit();
        myHTMLs = myTK.loadHTML();
        myStopWords = myTK.loadStopWords();

        loadData();
    }

    public static void main(String[] args) {
        NewsClassifier myNewsClassifier = new NewsClassifier();

        myNewsClassifier.newsCleanedContent = myNewsClassifier.preProcessing();

        myNewsClassifier.newsTFIDF = myNewsClassifier.calculateTFIDF(myNewsClassifier.newsCleanedContent);

        //Change the _index value to calculate similar based on a different news article.
        double[][] doubSimilarity = myNewsClassifier.newsSimilarity(0);

        System.out.println(myNewsClassifier.resultString(doubSimilarity, 10));

        String strGroupingResults = myNewsClassifier.groupingResults(myNewsClassifier.TITLE_GROUP1, myNewsClassifier.TITLE_GROUP2);
        System.out.println(strGroupingResults);
    }

    public void loadData() {
        //TODO 4.1 - 2 marks
        newsTitles = new String[myHTMLs.length];
        newsContents = new String[myHTMLs.length];
        for (int i = 0; i < myHTMLs.length; i++) {
            newsTitles[i] = HtmlParser.getNewsTitle(myHTMLs[i]);
            newsContents[i] = HtmlParser.getNewsContent(myHTMLs[i]);
        }
    }

    public String[] preProcessing() {
        String[] myCleanedContent;
        //TODO 4.2 - 5 marks
        myCleanedContent = new String[myHTMLs.length];
        for (int i = 0; i < newsContents.length; i++) {
            String strCleanedText = NLP.textCleaning(newsContents[i]);
            String strLemmatized = NLP.textLemmatization(strCleanedText);
            String strStopWords = NLP.removeStopWords(strLemmatized, myStopWords);
            myCleanedContent[i] = strStopWords;
        }
        //System.out.println("***General Processing Task!!!");
        return myCleanedContent;
    }

    public double[][] calculateTFIDF(String[] _cleanedContents) {
        String[] vocabularyList = buildVocabulary(_cleanedContents);
        double[][] myTFIDF;

        //TODO 4.3 - 10 marks
        myTFIDF = new double[_cleanedContents.length][vocabularyList.length];

        for (int d = 0; d < _cleanedContents.length; d++) {
            String doc = _cleanedContents[d];
            String[] words = doc.split(" ");
            double[] tfidfValues = new double[vocabularyList.length];

            for (int i = 0; i < vocabularyList.length; i++) {
                double tf = 0;
                for (String word : words) {
                    if (word.equals(vocabularyList[i])) {
                        tf++;
                    }
                }
                tf = tf / words.length;

                int count = 0;
                for (String doc1 : _cleanedContents) {
                    if (!notContains(doc1.split(" "), vocabularyList[i])) {
                        count++;
                    }
                }

                double idf = Math.log((double) _cleanedContents.length / count) + 1;
                tfidfValues[i] = tf * idf;
            }
            System.arraycopy(tfidfValues, 0, myTFIDF[d], 0, tfidfValues.length);
        }
        //System.out.println("***GTFIDF CalculationP Done!!!T");
        return myTFIDF;
    }

    public String[] buildVocabulary(String[] _cleanedContents) {
        String[] arrayVocabulary;

        //TODO 4.4 - 10 marks
        StringBuilder allWords = new StringBuilder();
        for (String doc : _cleanedContents) {
            allWords.append(doc).append(" ");
        }

        String[] arrayWords = allWords.toString().split(" ");
        arrayVocabulary = new String[arrayWords.length];
        int index = 0;

        for (String word : arrayWords) {
            if (notContains(arrayVocabulary, word)) {
                arrayVocabulary[index++] = word;
            }
        }

        arrayVocabulary = trimArray(arrayVocabulary, index);

        //System.out.println("***Generate a list of words for further Processing Task!!!");
        return arrayVocabulary;
    }


    public boolean notContains(String[] _arrayTarget, String _searchValue) {
        for (String element : _arrayTarget) {
            if (_searchValue.equals(element)) {
                return false;
            }
        }
        return true;
    }

    public String[] trimArray(String[] _arrayTarget, int _newSize) {
        String[] trimmedArray = new String[_newSize];
        System.arraycopy(_arrayTarget, 0, trimmedArray, 0, _newSize);
        return trimmedArray;
    }

    public int[] trimArray(int[] _arrayTarget, int _newSize) {
        int[] trimmedArray = new int[_newSize];
        System.arraycopy(_arrayTarget, 0, trimmedArray, 0, _newSize);
        return trimmedArray;
    }

    public double[][] newsSimilarity(int _newsIndex) {
        double[][] mySimilarity;

        //TODO 4.5 - 15 marks
        mySimilarity = new double[myHTMLs.length][2];
        if (_newsIndex > newsTitles.length) {
            return mySimilarity;
        }

        Vector myIndexVector = new Vector(newsTFIDF[_newsIndex]);

        for (int i = 0; i < newsTFIDF.length; i++) {
            Vector myVector = new Vector(newsTFIDF[i]);
            mySimilarity[i][0] = i;
            mySimilarity[i][1] = myIndexVector.cosineSimilarity(myVector);
        }

        int n = mySimilarity.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (mySimilarity[i - 1][1] < mySimilarity[i][1]) {
                    double[] temp = mySimilarity[i - 1];
                    mySimilarity[i - 1] = mySimilarity[i];
                    mySimilarity[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        return mySimilarity;
    }

    public String groupingResults(String _firstTitle, String _secondTitle) {
        int[] arrayGroup1, arrayGroup2;

        //TODO 4.6 - 15 marks
        int[] arrayFirstGroupIndex = new int[myHTMLs.length];
        int[] arraySecondGroupIndex = new int[myHTMLs.length];

        int indexGroup1 = 0, indexGroup2 = 0;
        int firstIndex = 0, secondIndex = 0;

        for (int i = 0; i < newsTitles.length; i++) {
            String newsTitle = newsTitles[i];
            if (newsTitle.equals(_firstTitle)) {
                firstIndex = i;
            } else if (newsTitle.equals(_secondTitle)) {
                secondIndex = i;
            }
        }

        Vector firstVector = new Vector(newsTFIDF[firstIndex]);
        Vector secondVector = new Vector(newsTFIDF[secondIndex]);

        for (int i = 0; i < myHTMLs.length; i++) {
            Vector myVector = new Vector(newsTFIDF[i]);
            if (firstVector.cosineSimilarity(myVector) >= secondVector.cosineSimilarity(myVector)) {
                arrayFirstGroupIndex[indexGroup1] = i;
                indexGroup1++;
            } else {
                arraySecondGroupIndex[indexGroup2] = i;
                indexGroup2++;
            }
        }

        arrayGroup1 = trimArray(arrayFirstGroupIndex, indexGroup1);
        arrayGroup2 = trimArray(arraySecondGroupIndex, indexGroup2);

        return resultString(arrayGroup1, arrayGroup2);
    }

    public String resultString(double[][] _similarityArray, int _groupNumber) {
        StringBuilder mySB = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        for (int j = 0; j < _groupNumber; j++) {
            for (int k = 0; k < _similarityArray[j].length; k++) {
                if (k == 0) {
                    mySB.append((int) _similarityArray[j][k]).append(" ");
                } else {
                    String formattedCS = decimalFormat.format(_similarityArray[j][k]);
                    mySB.append(formattedCS).append(" ");
                }
            }
            mySB.append(newsTitles[(int) _similarityArray[j][0]]).append("\r\n");
        }
        mySB.delete(mySB.length() - 2, mySB.length());
        return mySB.toString();
    }

    public String resultString(int[] _firstGroup, int[] _secondGroup) {
        StringBuilder mySB = new StringBuilder();
        mySB.append("There are ").append(_firstGroup.length).append(" news in Group 1, and ").append(_secondGroup.length).append(" in Group 2.\r\n").append("=====Group 1=====\r\n");

        for (int i : _firstGroup) {
            mySB.append("[").append(i + 1).append("] - ").append(newsTitles[i]).append("\r\n");
        }
        mySB.append("=====Group 2=====\r\n");
        for (int i : _secondGroup) {
            mySB.append("[").append(i + 1).append("] - ").append(newsTitles[i]).append("\r\n");
        }

        mySB.delete(mySB.length() - 2, mySB.length());
        return mySB.toString();
    }

}
