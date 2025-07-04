import java.io.File;
import java.io.IOException;

public class Table {
    public String dbPath ;
    public String tableName ;

    Table(String tableName , String dbPath){
        this.tableName = tableName ;
        this.dbPath = dbPath ;
        createTable();
    }
    public void createTable(){
        File file = new File(dbPath + "/" + tableName + ".csv");
        if (file.exists()){
            System.out.println("the table " +tableName + "already exits");
        }else {
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
