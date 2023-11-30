import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import uob.oop.HtmlParser;
import uob.oop.Toolkit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AM_HtmlParser {
    //String[] strHTML = Toolkit.loadHTML();
    private String strHTML2 = "This is a test string";
    private String strHTML3 = "<title>The </title of the news is <title> | </title>\"articleBody\": \"articleBody and mainEntityOfPage is the actual content  \",\"mainEntityOfPage\":";
    public static double doubMarks = 0;

    @Test
    @Order(1)
    void getNewsTitle_0() {
        Toolkit myTK = new Toolkit();
        String[] strHTML = myTK.loadHTML();
        assertEquals("ChatGPT predicted Rishi Sunak's speech about AI - here's how it did", HtmlParser.getNewsTitle(strHTML[0]));
        doubMarks += 1;
    }

    @Test
    @Order(2)
    void getNewsTitle_Last() {
        Toolkit myTK = new Toolkit();
        String[] strHTML = myTK.loadHTML();
        assertEquals("Who is Sam Altman? The OpenAI boss and ChatGPT guru who is now one of AI's biggest players", HtmlParser.getNewsTitle(strHTML[strHTML.length - 1]));
        doubMarks += 1;
    }

    @Test
    @Order(3)
    void getNewsTitle_HTML2() {
        assertEquals("Title not found!", HtmlParser.getNewsTitle(strHTML2));
        doubMarks += 1;
    }

    @Test
    @Order(4)
    void getNewsTitle_HTML3() {
        assertEquals("The </title of the news is <title>", HtmlParser.getNewsTitle(strHTML3));
        doubMarks += 2;
    }


    @Test
    @Order(5)
    void getNewsContent_0() {
        Toolkit myTK = new Toolkit();
        String[] strHTML = myTK.loadHTML();
        assertEquals("chatgpt can be tricked into producing malicious code that could be used to launch cyberattacks, a study has found. openai's tool and similar chatbots can create written content based on user commands, having been trained on enormous amounts of text data from across the internet. they are designed with protections in place to prevent their misuse, along with address issues such as biases. as such, bad actors have turned to alternatives that are purposefully created to aid cyber crime, such as a dark web tool called wormgpt that experts have warned could help develop large-scale attacks. but researchers at the university of sheffield have warned that vulnerabilities also exist in mainstream options that allow them to be tricked into helping destroy databases, steal personal information, and bring down services. these include chatgpt and a similar platform created by chinese company baidu. computer science phd student xutan peng, who co-led the study, said: \\\"the risk with ais like chatgpt is that more and more people are using them as productivity tools, rather than as a conversational bot. \\\"this is where our research shows the vulnerabilities are.\\\" read more:martin lewis warns against 'frightening' ai scam videoai 'doesn't have capability to take over', says microsoft boss ai-generated code 'can be harmful' much like these generative ai tools can inadvertently get their facts wrong when answering questions, they can also create potentially damaging computer code without realising. mr peng suggested a nurse could use chatgpt to write code for navigating a database of patient records. \\\"code produced by chatgpt in many cases can be harmful to a database,\\\" he said. \\\"the nurse in this scenario may cause serious data management faults without even receiving a warning.\\\" during the study, the scientists themselves were able to create malicious code using baidu's chatbot. the company has recognised the research and moved to address and fix the reported vulnerabilities.  such concerns have resulted in calls for more transparency in how ai models are trained, so users become more understanding and perceptive of potential problems with the answers they provide. cybersecurity research firm check point has also urged companies to upgrade their protections as ai threatens to make attacks more sophisticated. it will be a topic of conversation at the uk's ai safety summit next week, with the government inviting world leaders and industry giants to come together to discuss the opportunities and dangers of the technology.", HtmlParser.getNewsContent(strHTML[1]));
        doubMarks += 1;
    }

    @Test
    @Order(6)
    void getNewsContent_Last() {
        Toolkit myTK = new Toolkit();
        String[] strHTML = myTK.loadHTML();
        assertEquals("he was a tech whizz before he left primary school, dropped out of one of america's top universities, and now appears to be spearheading a revolution that could change our lives forever. so far, so silicon valley. and like so many of the billionaire entrepreneurs that have emerged from that infamous stretch of sunny california, openai's sam altman appears well on his way to becoming a household name. the fresh-faced 38-year-old would have been unknown to most outside tech circles before the launch of his firm's breakthrough chatbot chatgpt, but he now spends much of his increasingly precious time rubbing shoulders with world leaders and some of america's most recognisable executives. his path to becoming \\\"a remarkable figure in the realm of innovation and entrepreneurship\\\" (those are chatgpt's words when asked for an introduction to its chief creator, not mine) began at his childhood home in missouri, where eight-year-old altman was gifted his first computer, quickly learning not just how to use it, but to program for it. altman attended john burroughs school in st louis, and told the new yorker in a 2016 interview that having his computer helped him come to terms with his sexuality and come out to his parents when he was a teenager. \\\"growing up gay in the midwest in the 2000s was not the most awesome thing,\\\" he recalled. \\\"and finding aol chatrooms was transformative. secrets are bad when you are 11 or 12.\\\" a familiar dropout with school in the rear view mirror, it was time for university - stanford, no less. altman made his way to that famous california institution to study computer science, but dropped out after just two years, following in the footsteps of previous dropouts-turned-tech superstars bill gates and mark zuckerberg, who both abandoned their harvard degrees before becoming two of history's most influential ceos. abandoning a precious spot at one of america's top universities seemed such a rite of passage for the country's leading tech entrepreneurs that it played right into the success story of the now disgraced elizabeth holmes, whose departure from stanford to gatecrash silicon valley led to a wave of media attention not dissimilar to that currently given to altman. his first post-university venture was a smartphone app called loopt, which let users selectively share their real-time location with other people. some $30m (&#163;24m) was raised to launch the company, aided by funding from a start-up accelerator firm called y combinator, which lists the likes of airbnb and twitch among the internet companies it has helped establish. altman became president of y combinator itself in 2014, after the sale of loopt for $44m (&#163;35m) in 2012. he also founded his own venture capital fund called hydrazine capital, attracting enough investment to be named on the forbes 30 under 30 list for venture capital. as if he wasn't busy enough, altman also ran reddit for a grand total of eight days amid a leadership shake-up in 2014, describing his tenure as \\\"sort of fun\\\". the rise of openai while his time at the top of reddit only lasted eight days, his oversight of openai has now lasted eight years. he's \\\"doing pretty well\\\" with it, he said in a february tweet (certainly compared to loopt, which, he now says, \\\"sucked\\\").  he launched the company with a certain elon musk (who only ran spacex and tesla at the time) in 2015, the two men providing funding alongside the likes of amazon and microsoft, totalling $1bn (&#163;800m). it was run as a non-profit with the noble goal of developing ai while making sure it doesn't wipe out humanity. so far, mission accomplished - but if altman's to be believed, the risk since has become very real indeed. under his tenure, openai has ceased to be a non-profit and now has an estimated value of up to $29bn (&#163;23bn), all thanks to the remarkable success of its generative ai tools - chatgpt for text and dall-e for images. microsoft boss satya nadella has described altman as an \\\"unbelievable entrepreneur\\\" who bets big and bets right, which openai's success makes hard to argue with. chatgpt amassed tens of millions of users within weeks of launching in late 2022, wowing experts and casual observers alike with its ability to pass the world's toughest exams, get through job applications, compose anything from political speeches to children's homework, and write its own computer code. suddenly the concept of a large language model (meaning it is trained on huge amounts of text data so that it can understand our requests and respond accordingly) became something of a mainstream buzz term, its popularity seeing microsoft invest extra cash into openai and bring the tech to its bing search engine and office apps. google also got in on the act with its bard chatbot, some of china's biggest tech companies entered the race, while musk - who left openai in 2018 due to a conflict of interest with tesla's work on self-driving ai - has said he wants to launch his own one too. all the while, openai's technology is also improving - an upgrade dubbed gpt-4 within months of chatgpt's release showing just how quickly these models can develop. read more:we asked a chatbot to help write an article  'my worst fears' but for all the wonder such systems have provided, it's matched - if not surpassed - by the concerns. whether it be spreading disinformation or making jobs redundant, governments are scrambling to formulate an effective way of regulating a technology that seems destined to change the world forever. perhaps with an eye on how some of his silicon valley contemporaries have failed to act on the dangers of their creations before it's too late, altman appears keen to be a willing participant in just how it should be done. \\\"my worst fears are that we, the industry, cause significant harm to the world,\\\" altman told the us senate, his assessment that government regulation would be \\\"critical to mitigate the risks\\\" undoubtedly music to the ears of politicians who never seem overly impressed by figures from the tech world. read more:who is the 'godfather of ai'?  in the space of a few short weeks, altman met the us vice president, kamala harris, france's emmanuel macron, european commission president ursula von der leyen and the british prime minister, rishi sunak - all politicians who share the same hopes and fears about the potential benefits and dangers of ai. with the eu seemingly none too impressed by elon musk's running of twitter, tiktok managing to achieve the mostly impossible task of uniting democrats and republicans against a common enemy, and mark zuckerberg having struggled to repair his reputation after the cambridge analytica scandal, the upstart altman could be positioning himself to become a more durable tech star than some of his forebears.  but just in case it does all go wrong, he's previously admitted to being a prepper - someone who stockpiles everything from guns to medicine should the worst should befall us. let's hope he's being overly cautious.", HtmlParser.getNewsContent(strHTML[strHTML.length - 1]));
        doubMarks += 1;
    }

    @Test
    @Order(7)
    void getNewsContent_HTML2() {
        assertEquals("Content not found!", HtmlParser.getNewsContent(strHTML2));
        doubMarks += 1;
    }

    @Test
    @Order(8)
    void getNewsContent_HTML3() {
        assertEquals("articlebody and mainentityofpage is the actual content ", HtmlParser.getNewsContent(strHTML3));
        doubMarks += 2;
    }

    @Test
    @Order(9)
    void Marks() {
        System.out.println("===============================");
        System.out.println("Task 1 Marks: " + doubMarks + "/10.0");
        System.out.println("===============================");
    }

}
