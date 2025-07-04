//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DB db = new DB("myDB") ;
        Table usersTable =    db.createTable("users");
        Table postsTable = db.table("posts");
        System.out.println(postsTable.getPath());
    }
}