import java.io.File;

public class DB {
    final String directory = "data";
    public String dbName;
    final String RED = "\u001B[31m";
    final String RESET = "\u001B[0m";
    DB(String dbName) {
        System.out.println( RED +"▄▖▘     ▜     ▄ ▄ \n" +
                "▚ ▌▛▛▌▛▌▐ █▌  ▌▌▙▘\n" +
                "▄▌▌▌▌▌▙▌▐▖▙▖▗ ▙▘▙▘\n" +
                "      ▌           \n" +
                "\n"+RESET);
        this.dbName = dbName;
        createDB();

    }
    public String getPath(){
        return directory + "/" + dbName ;
    }
    public void createDB() {
        File file = new File(directory + "/" + dbName);
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("The database is created successfully");
        } else {
            System.out.println("The database " + dbName + " already exists");
        }
    }

    public void deleteDB() {
        File file = new File(directory + "/" + dbName);
        if (file.exists()) {
            if (deleteRecursively(file)) {
                System.out.println("The database is deleted");
            } else {
                System.out.println("Failed to delete the database");
            }
        } else {
            System.out.println("The database " + dbName + " does not exist");
        }
    }

    private boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    if (!deleteRecursively(child)) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }
    public Table createTable (String tableName){
            return (new Table(tableName , getPath()));

    }
    public Table table(String tableName){
            return (new Table(tableName , getPath())) ;
    }
    public void deleteTable(String tableName){
        File table = new File(getPath()+"/"+tableName+".csv");
        if (!table.exists()){
            System.out.println("the table doesnt exist");
        }else {
            table.delete();
            System.out.println("the table is deleted");
        }
    }
}
