import java.io.*;
import java.net.*;
import java.util.*;

public class server1 {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            listener = new ServerSocket(9999);
            System.out.println("연결을 기다리고있습니다.......");
            socket =listener.accept();
            System.out.println("연결되었습니다");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String inputMessage = in.readLine();
                if (inputMessage.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트에서 bye로 연결을 종료하였음");
                    break;
                }
                System.out.println("클라이언트" + inputMessage);
                System.out.print("보내기>>");
                String outputMessage = scanner.nextLine();
                out.write(outputMessage + "\n");
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close();
                socket.close();
                listener.close();
            } catch (IOException e) {
                System.out.println("클라이언트와 채팅 중 오류가 발생 했습니다.");
            }

        }
    }

    public static class client1 {
        public static void main(String[] args) {
            BufferedReader in = null;
            BufferedWriter out = null;
            Socket socket = null;
            Scanner scanner = new Scanner(System.in);
            try{
                socket =new Socket("localhost",9999);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                while (true){
                    System.out.print("보내기>>");
                    String outputMessage =scanner.nextLine();
                    if (outputMessage.equalsIgnoreCase("bye")){
                        out.write(outputMessage+"\n");
                        out.flush();
                        break;
                    }
                    out.write(outputMessage+"\n");
                    out.flush();
                    String inputMessage = in.readLine();
                    System.out.println("서버:"+inputMessage);
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    scanner.close();
                    if (socket !=null)socket.close();
                }catch (IOException e){
                    System.out.println("서버와채팅중 오류가 발생했습니다");
                }
            }

        }
    }

    public static class client {
        public static void main(String[] args) {
            BufferedReader in = null;
            BufferedWriter out = null;
            Socket socket = null;
            Scanner scanner = new Scanner(System.in);
         try{
        socket =new Socket("localhost",9999);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        while (true){
          System.out.print("보내기>>");
          String outputMessage =scanner.nextLine();
          if (outputMessage.equalsIgnoreCase("bye")){
              out.write(outputMessage+"\n");
              out.flush();
              break;
          }
          out.write(outputMessage+"\n");
          out.flush();
            String inputMessage = in.readLine();
            System.out.println("서버:"+inputMessage);
        }
     }catch (IOException e){
             System.out.println(e.getMessage());
         }finally {
             try {
                 scanner.close();
                 if (socket !=null)socket.close();
             }catch (IOException e){
                 System.out.println("서버와채팅중 오류가 발생했습니다");
             }
         }

        }
    }
}
