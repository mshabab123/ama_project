package products;



import java.io.*;

public class repleceCategoriesNames
    {
     public static void main(String args[])
         {
         try
             {
             File file = new File("users1");
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = reader.readLine()) != null)
                 {
                 oldtext += line + "\r\n";
             }
             reader.close();
             // replace a word in a file
             
             
             System.out.println("we are staring now");
             String newtext = oldtext.replaceAll("amazon_instant_video", "1");
              newtext = newtext.replaceAll("arts", "2");
              newtext = newtext.replaceAll("automotive", "3");
              newtext = newtext.replaceAll("baby", "4");
              newtext = newtext.replaceAll("beauty", "5");
              newtext = newtext.replaceAll("books", "6");
              newtext = newtext.replaceAll("cell_phones_accessories", "7");
              newtext = newtext.replaceAll("clothing_accessories", "8");
              newtext = newtext.replaceAll("electronics", "9");
              newtext = newtext.replaceAll("gourmet_foods", "10");
              newtext = newtext.replaceAll("health", "11");
              System.out.println("replecing number 12");
              newtext = newtext.replaceAll("home_kitchen", "12");
              newtext = newtext.replaceAll("industrial_scientific", "13");
              newtext = newtext.replaceAll("jewelry", "14");
              newtext = newtext.replaceAll("kindle_store", "15");
              newtext = newtext.replaceAll("movies_tv", "16");
              newtext = newtext.replaceAll("music", "17");
              newtext = newtext.replaceAll("musical_instruments", "18");

              newtext = newtext.replaceAll("office_products", "19");
              newtext = newtext.replaceAll("patio", "20");
              newtext = newtext.replaceAll("pet_supplies", "21");
              newtext = newtext.replaceAll("shoes", "22");
              newtext = newtext.replaceAll("software", "23");
              System.out.println("replecing number 24");

              newtext = newtext.replaceAll("sports_outdoors", "24");
              newtext = newtext.replaceAll("tools_home_improvement", "25");
              newtext = newtext.replaceAll("toys_games", "26");
              newtext = newtext.replaceAll("video_games", "27");
              newtext = newtext.replaceAll("watches", "28");
              


            
             //To replace a line in a file
             //String newtext = oldtext.replaceAll("This is test string 20000", "blah blah blah");
              System.out.println("writning");

             FileWriter writer = new FileWriter("stream");
             writer.write(newtext);writer.close();
         }
         catch (IOException ioe)
             {
             ioe.printStackTrace();
         }
     }
}
