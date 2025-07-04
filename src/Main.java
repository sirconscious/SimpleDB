//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DB db = new DB("myDB") ;
         //Table usersTable =    db.createTable("users");
        Table blogs = db.table("blogs") ;
//        blogs.defineColumns(new String[]{"id", "title" , "body"});
//        blogs.insertOne(new String[]{"1" , "test","this is just a test"});
//        blogs.insertOne(new String[]{"2" , "test","this is just a test"});
//        blogs.insertOne(new String[]{"3" , "test","this is just a test"});
//        blogs.insertMany(new String[][]{{"4" , "test","this is just a test"} ,
//                {"5" , "test","this is just a test"}
//                ,{"6" , "test","this is just a test"}
//        });
        blogs.getAll();
        blogs.getOne("title" , "test4");
    }
}