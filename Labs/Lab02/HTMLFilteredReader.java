import cs1.SimpleURLReader;
/*
 * HTMLFilteredReader
 * @author Ege Darcin
 * @version 1.1
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
  //constructor
  public HTMLFilteredReader ( String url)
  {
    super( url );
  }
  
  //methods  
  public String getPageContents(){
    
    String temp = super.getPageContents();
    String content1 = "";
    String content2 = "";
    
    boolean kontrol = true;
    for( int i = 0; i < temp.length(); i++)
    {
      
      if( temp.charAt(i) == '<')
        kontrol= false;
      
      if (kontrol)
        content1 = content1 + temp.charAt(i);
      
      if( temp.charAt(i) == '>')
        kontrol = true;
      
    }
    
    for( int j = 0; j < content1.length(); j++)
    {
      
      if(content1.charAt(j) == '&')
        kontrol= false;
      
      if (kontrol)
        content2 = content2 + content1.charAt(j);
      
      if(content1.charAt(j) == 'p')
        kontrol = true;
      
    }
    return content2;
  }
  
  public String getUnfilteredPageContents()
  {
    return super.getPageContents();
  }
}