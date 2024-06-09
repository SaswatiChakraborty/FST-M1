package src.activities;

public class MyBook extends Book {

    void setTitle(String title){
        this.title = title;
    }

    public static void main(String[] args){
        MyBook newNovel = new MyBook();
        newNovel.setTitle("Harry Potter and the Philosopher's Stone");
        System.out.println(newNovel.getTitle());
    }
}
