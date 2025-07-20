package baylinux.sagliktest;


/**
 * Hello world!
 *
 */
public class FakeMain
{
    public static void main( String[] args ) throws Exception
    {
    	try 
    	{
            NativeLoader.loadOpenCV();
        } 
    	catch (Exception e) 
    	{
            e.printStackTrace();
        }
    	
        Main.main(args);
    }
}
