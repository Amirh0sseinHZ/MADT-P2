package com.example.madt_p2;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperUnitTest {

    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_numWordsIsCalled_Then_NullPointerExceptionIsThrown(){
        StringHelper.numWords(null);
    }

    @Test
    public void Given_EmptyString_When_numWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSingleEmptySpace_When_numWordsIsCalled_Then_ReturnedZero(){
        final String givenString = " ";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleEmptySpaces_When_numWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "   ";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringWithEmptySpacesAtTheBeginning_When_numWordsIsCalled_Then_ReturnedOne(){
        final String givenString = "   hello";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringWithEmptySpacesAtTheEnd_When_numWordsIsCalled_Then_ReturnedOne(){
        final String givenString = "hello   ";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringWithEmptySpacesAtBothSides_When_numWordsIsCalled_Then_ReturnedOne(){
        final String givenString = "   hello   ";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringWithMultipleSpaceSeparatedWords_When_numWordsIsCalled_Then_ReturnedThree(){
        final String givenString = "Hello amazing world";

        final int expectedResult = 3;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringWithMultipleDotSeparatedWords_When_numWordsIsCalled_Then_ReturnedThree(){
        final String givenString = "Hello.amazing.world";

        final int expectedResult = 3;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfOneDot_When_numWordsIsCalled_Then_ReturnedZero(){
        final String givenString = ".";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleDots_When_numWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "...";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleSeparatedDots_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = ". . .";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleSeparatedSpecialCharacters_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = ". , >  < ' \" ; : / \\ | ] [ } { = + _ - ) ( * & ^ % $ # @ ! ` ~";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfOneDigit_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "1";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleDigits_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "111";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleNumbers_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "0 1 22 333 4444 55555 666666 7777777 88888888 999999999";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfOneEmote_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "\uD83D\uDE03";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleEmotes_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "\uD83D\uDE03\uD83D\uDE03\uD83D\uDE03";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleSpaceSeparatedEmotes_When_namWordsIsCalled_Then_ReturnedZero(){
        final String givenString = "\uD83D\uDE03 \uD83D\uDE03 \uD83D\uDE03";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleWordsNumbersSpecialCharactersAndExtraSpaces_When_namWordsIsCalled_Then_ReturnedTwelve(){
        final String givenString = "  Lorem 1psum. Is simply-dummy  1 2 3 44 555 000  text! Of (the printing) and typesetting industry? ";

        final int expectedResult = 12;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSentence_When_namWordsIsCalled_Then_ReturnedFourteen(){
        final String givenString = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.";

        final int expectedResult = 14;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfParagraph_When_namWordsIsCalled_Then_ReturnedNinetyTwo(){
        final String givenString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        final int expectedResult = 92;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNonASCIIChar_When_numWordsIsCalled_Then_ReturnedOne(){
        final String givenString = "诶";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNonASCIIWord_When_numWordsIsCalled_Then_ReturnedOne(){
        final String givenString = "問候語";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNonASCIISentence_When_numWordsIsCalled_Then_ReturnedFour(){
        final String givenString = "ეს არის სატესტო სტრიქონი.";

        final int expectedResult = 4;
        final int actualResult = StringHelper.numWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_numCharsIsCalled_Then_NullPointerExceptionIsThrown(){
        StringHelper.numChars(null);
    }

    @Test
    public void Given_EmptyString_When_numCharsIsCalled_Then_ReturnedZero(){
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmptyStringOfOneSpace_When_numCharsIsCalled_Then_ReturnedOne(){
        final String givenString = " ";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmptyStringOfMultipleSpaces_When_numCharsIsCalled_Then_ReturnedThree(){
        final String givenString = "   ";

        final int expectedResult = 3;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSingleChar_When_numCharsIsCalled_Then_ReturnedOne(){
        final String givenString = "a";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleSpaceSeparatedChars_When_numCharsIsCalled_Then_ReturnedFive(){
        final String givenString = "a a a";

        final int expectedResult = 5;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleSpaceSeparatedCharsWithExtraSpaceAtSides_When_numCharsIsCalled_Then_ReturnedSeven(){
        final String givenString = " a a a ";

        final int expectedResult = 7;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSingleWord_When_numCharsIsCalled_Then_ReturnedFive(){
        final String givenString = "hello";

        final int expectedResult = 5;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleWords_When_numCharsIsCalled_Then_ReturnedNineteen(){
        final String givenString = "hello amazing world";

        final int expectedResult = 19;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSingleDigit_When_numCharsIsCalled_Then_ReturnedOne(){
        final String givenString = "1";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleDigits_When_numCharsIsCalled_Then_ReturnedThree(){
        final String givenString = "123";

        final int expectedResult = 3;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleNumbers_When_numCharsIsCalled_Then_ReturnedFiftyFive(){
        final String givenString = "0 1 22 333 4444 55555 666666 7777777 88888888 999999999";

        final int expectedResult = 55;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleSeparatedSpecialCharacters_When_numCharsIsCalled_Then_ReturnedSixtyTwo(){
        final String givenString = ". , >  < ' \" ; : / \\ | ] [ } { = + _ - ) ( * & ^ % $ # @ ! ` ~";

        final int expectedResult = 62;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSentence_When_numCharsIsCalled_Then_ReturnedSeventySeven(){
        final String givenString = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.";

        final int expectedResult = 77;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfParagraph_When_numCharsIsCalled_Then_ReturnedFiveHundredSeventyFour(){
        final String givenString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        final int expectedResult = 574;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfSingleEmote_When_numCharsIsCalled_Then_ReturnedTwo(){
        final String givenString = "\uD83D\uDE03";

        final int expectedResult = 2;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleEmotes_When_numCharsIsCalled_Then_ReturnedEight(){
        final String givenString = "\uD83D\uDE03 \uD83D\uDE03 \uD83D\uDE03";

        final int expectedResult = 8;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNonASCIIChar_When_numCharsIsCalled_Then_ReturnedOne(){
        final String givenString = "诶";

        final int expectedResult = 1;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNonASCIIWord_When_numCharsIsCalled_Then_ReturnedThree(){
        final String givenString = "問候語";

        final int expectedResult = 3;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNonASCIISentence_When_numCharsIsCalled_Then_ReturnedTen(){
        final String givenString = "這是一個測試字符串。";

        final int expectedResult = 10;
        final int actualResult = StringHelper.numChars(givenString);

        assertEquals(expectedResult, actualResult);
    }
}