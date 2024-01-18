import java.util.ArrayList;

public class main {
    public static void main(String []args){
        Facebook facebook = new Facebook();
        Instagram instagram = new Instagram();
        Twitter twitter = new Twitter();

        ArrayList<IMessage> mensagens = new ArrayList<IMessage>();
        mensagens.add(facebook);
        mensagens.add(twitter);
        mensagens.add(instagram);

        mensagens.forEach((e) -> System.out.println(e.lerMensagem()));
    }
}
