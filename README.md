# NewsClassifier

A Java-based News Classifier that categorizes news articles by their content using Natural Language Processing (NLP) and vector space models.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [How It Works](#how-it-works)
- [Project Structure](#project-structure)
- [Dataset](#dataset)
- [Installation & Usage](#installation--usage)
- [Testing](#testing)
- [Dependencies](#dependencies)

---

## Introduction
This project implements a news classifier that groups news articles based on their semantic similarity. It leverages classic NLP techniques such as text cleaning, lemmatization, stop-word removal, TF-IDF vectorization, and cosine similarity to cluster articles into topics. The dataset consists of 26 real news articles from Sky News, provided as HTML files.

## Features
- **HTML Parsing**: Extracts titles and content from raw HTML news files.
- **NLP Preprocessing**: Cleans, lemmatizes, and removes stop words from article text.
- **TF-IDF Embedding**: Converts documents into high-dimensional vectors reflecting word importance.
- **Cosine Similarity**: Measures semantic closeness between articles.
- **Automatic Grouping**: Clusters articles into two main topics based on similarity.
- **Comprehensive Unit Tests**: Ensures correctness of all major components.

## How It Works
1. **HTML Parsing**: The `HtmlParser` extracts the title and main content from each HTML file.
2. **Text Preprocessing**: The `NLP` class:
   - Converts text to lowercase and removes special characters.
   - Lemmatizes words by stripping common suffixes (e.g., 'ing', 'ed', 'es', 's').
   - Removes common stop words (from `stopwords.csv`).
3. **TF-IDF Vectorization**: Each cleaned article is transformed into a TF-IDF vector, where each dimension represents a word's importance in the document relative to the corpus.
4. **Cosine Similarity**: The `Vector` class computes the cosine similarity between article vectors to assess semantic closeness.
5. **Grouping**: Articles are grouped by comparing their similarity to two reference articles (one from each topic).

## Project Structure
```
NewsClassifier/
├── src/
│   ├── main/
│   │   ├── java/uob/oop/
│   │   │   ├── HtmlParser.java      # HTML parsing utilities
│   │   │   ├── NLP.java            # Text preprocessing (cleaning, lemmatization, stop-word removal)
│   │   │   ├── NewsClassifier.java # Main logic and entry point
│   │   │   ├── Toolkit.java        # File loading utilities
│   │   │   └── Vector.java         # Vector operations and similarity
│   │   └── resources/
│   │       ├── News/               # 26 HTML news articles (01.htm, 02.htm, ...)
│   │       └── stopwords.csv       # List of stop words
│   └── test/java/                  # JUnit test classes for all modules
├── pom.xml                         # Maven project file
└── README.md                       # Project documentation
```

## Dataset
- **Location**: `src/main/resources/News/`
- **Format**: Each article is an HTML file (e.g., `01.htm`, `02.htm`, ...).
- **Stop Words**: `src/main/resources/stopwords.csv` (127 common English stop words)

## Installation & Usage
### Prerequisites
- Java 17+
- Maven

### Build & Run
1. **Clone the repository**
2. **Build the project**:
   ```sh
   mvn clean compile
   ```
3. **Run the classifier**:
   ```sh
   mvn exec:java -Dexec.mainClass="uob.oop.NewsClassifier"
   ```
   The output will display the similarity results and groupings of the news articles.

## Testing
Comprehensive unit tests are provided for all major components:
- `AM_HtmlParser.java`: Tests HTML parsing.
- `AM_NLP.java`: Tests text cleaning, lemmatization, and stop-word removal.
- `AM_Vector.java`: Tests vector operations and similarity.
- `AM_NewsClassifier.java`: Tests the full pipeline and grouping logic.

To run all tests:
```sh
mvn test
```

## Dependencies
- JUnit 4.13.1 & JUnit Jupiter (for testing)
