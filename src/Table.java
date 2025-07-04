import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Table {
    public String dbPath ;
    public String tableName ;

    Table(String tableName , String dbPath){
        this.tableName = tableName ;
        this.dbPath = dbPath ;
        createTable();
    }
    public String getPath(){
        return dbPath + "/" + tableName ;
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
    public void deletTable(){
        File file = new File(dbPath + "/" + tableName + ".csv");
        if (!file.exists()){
            System.out.println("the table " +tableName + " does not exist");
        }else if(file.delete()){
            System.out.println("the table " + tableName + " is deleted successfully");
        }
    }

    public void defineColumns(String[] columns){

        try (FileWriter file = new FileWriter(dbPath + "/" + tableName + ".csv") ;){
            for (int i = 0 ; i < columns.length ; i++){
                file.append(columns[i])
                        .append(i < columns.length - 1 ? "," : "\n");            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
