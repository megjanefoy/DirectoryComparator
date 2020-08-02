import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** 
 * Title: Assignment 6 
 * Semester: COP3337 – Fall 2019
 * @author Megan Jane Thompson
 * 
 * This a comparator program that compares Strings
 * which start with letters and end with digits. It
 * will return values corresponding to sorting in 
 * ascending order.
 */

public class DirectoryComparator implements Comparator<String>{

  /**
   * This method takes in two Strings and sorts them in
   * lexicographical order. The alphabetic portions 
   * are compared first, then the numerical portions are compared.
   * 
   * @override
   * @param firstString, being the first String to compare.
   * @param secondString, being the second String to compare.
   * @return returnVal, being an int 0 if boths strings are 
   * identical, -1 if the firstString comes before the secondString,
   * or 1 if the firstString comes after the secondString.
  */  
  public int compare(String firstString, String secondString){
    Pattern pattern = Pattern.compile("([A-Za-z]+)(\\d+)");    //compiles pattern to two groups: (alpha) and (numbers)
    Matcher match1 = pattern.matcher(firstString);             //applies pattern to firstString and sets to match1
    Matcher match2 = pattern.matcher(secondString);            //applies pattern to secondString and sets to match2
    
    String firstStringAlpha = "";
    String secondStringAlpha = "";
    String firstStringNum = "";
    String secondStringNum = "";
    Integer returnVal = null;
    
    if (match1.matches()){                                     //checks to see if firstString matches
      firstStringAlpha = match1.group(1);                      //obtains alphabetic portion of firstString
      firstStringNum = match1.group(2);                        //obtains numerical portion of firstString
    }
    if (match2.matches()){                                     //checks to see if secondString matches
      secondStringAlpha = match2.group(1);                     //obtains alphabetic portion of secondString
      secondStringNum = match2.group(2);                       //obtains numberical portion of secondString
    }
    
    if (firstStringAlpha.compareTo(secondStringAlpha) == 0){   //if alpha portions match, compares based on num portion
      int firstNum = Integer.parseInt(firstStringNum);         //converts firstSting num portion from String to int
      int secondNum = Integer.parseInt(secondStringNum);       //converts secondString num portion from String to int
      if (firstNum == secondNum){                              //checks if num portions match
        returnVal = 0;                                         //returns 0 if alpha and num portions match
      }
      else if (firstNum < secondNum){                          //checks if firstNum comes before secondNum
        returnVal = -1;                                        //returns -1 if alphas match and firstNum < secondNum
      }  
      else if (firstNum > secondNum){                          //checks if firstNum comes after secondNum
        returnVal = 1;                                         //returns 1 if alphas match and firstNum > secondNum
      }
    }
    else if (firstStringAlpha.compareTo(secondStringAlpha) < 0){ //checks if first alpha portion comes before second 
      returnVal = -1;                                           //returns -1 if first alpha portion comes before second
    }
    else if (firstStringAlpha.compareTo(secondStringAlpha) > 0){ //checks if first alpha portion comes after second
      returnVal = 1;                                            //returns 1 if first alpha portion comes before second
    }

    //returns 0 if strings are identical, -1 if the firstString < secondString, or 1 if the firstString > secondString
    return returnVal;               
  }


}
