public class Logger{

    private static Logger instance;
    
    //constructor
    private Logger(){

    }

    public static Logger getLogger(){
        if(instance == null ){

            synchronized (Logger.class){
                if(instance == null ){
                     instance = new Logger();
                }
            }
         
        }

        return instance;
    }
}