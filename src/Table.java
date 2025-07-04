import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Table {
    public String dbPath ;
    public String tableName ;
    private boolean columnsDefined =false;
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
        if (!this.columnsDefined){

        try (FileWriter file = new FileWriter(dbPath + "/" + tableName + ".csv" ) ;){
            for (int i = 0 ; i < columns.length ; i++){
                file.append(columns[i])
                        .append(i < columns.length - 1 ? "," : "\n");            }
            this.columnsDefined = true ;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        }
    }
    public void insertOne(String[] values){
        if (!this.columnsDefined){
            System.out.println("you must define the columns first") ;
        }else {
            try(FileWriter file = new FileWriter(dbPath+"/"+tableName+".csv" , true);){
            for (int i=0 ; i < values.length ; i++ ){
                file.append(values[i])
                        .append(i < values.length - 1 ? "," : "\n");             }
            System.out.println("the values are inserted");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
    public void insertMany(String[][] values){
        if (!this.columnsDefined){
            System.out.println("you must define the columns first") ;
        }else {
            try(FileWriter file = new FileWriter(dbPath+"/"+tableName+".csv" , true);){
                for (String[] line : values){
                    for (int j=0 ; j < line.length ; j++){
                        file.append(line[j])
                                .append(j < values.length - 1 ? "," : "\n");
                    }
                }
                System.out.println("the values are inserted");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
    public void getAll() {
        File file = new File(dbPath + "/" + tableName + ".csv");
        List<List<String>> table = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(","));
                table.add(row);
            }

            for (List<String> row : table) {
                System.out.println(row);
            }

            System.out.println("Total lines: " + table.size());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public void getOne(String column, String value) {
        File file = new File(dbPath + "/" + tableName + ".csv");

        if (!file.exists()) {
            System.out.println("The table doesn't exist.");
            return;
        }

        try (Scanner reader = new Scanner(file)) {
            List<String> cols = Arrays.asList(reader.nextLine().split(","));

            if (!cols.contains(column)) {
                System.out.println("The column provided doesn't exist.");
                return;
            }

            int index = cols.indexOf(column);
            List<List<String>> matchedRows = new ArrayList<>();

            while (reader.hasNextLine()) {
                List<String> currentRow = Arrays.asList(reader.nextLine().split(","));
                if (currentRow.size() > index && currentRow.get(index).equals(value)) {
                    matchedRows.add(currentRow);
                }
            }

            if (matchedRows.isEmpty()) {
                System.out.println("No matching rows found.");
            } else {
                System.out.println(String.join(" | ", cols)); // Print headers
                for (List<String> row : matchedRows) {
                    System.out.println(String.join(" | ", row));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}
