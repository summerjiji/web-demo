package sss;

public class ProduceConsume {  
	  
    public static void main(String[] args) {  
        SyncStack ss = new SyncStack();//����һ��װ��ͷ�Ŀ�  
        Producer p = new Producer(ss);//�½�һ�������ߣ�ʹ֮���п�  
        Consume c = new Consume(ss);//�½�һ�������ߣ�ʹ֮����ͬһ����  
        Thread tp = new Thread(p);//�½�һ���������߳�  
        Thread tc = new Thread(c);//�½�һ���������߳�  
        tp.start();//�����������߳�  
        tc.start();//�����������߳�  
    }  
  
}  
  
//��ͷ��  
class SteamBread{  
    int id;//��ͷ���  
    SteamBread(int id){  
        this.id = id;  
    }  
    public String toString(){  
        return "steamBread:"+id;  
    }  
}  
  
//װ��ͷ�Ŀ�ջ�ṹ  
class SyncStack{  
    int index = 0;  
    SteamBread[] stb = new SteamBread[6];//������ͷ���飬�൱����ͷ��������6  
      
    //������У��൱����ջ  
    public synchronized void push(SteamBread sb){  
        while(index==stb.length){//�����ˣ���ջ����  
            try {  
                this.wait();//�õ�ǰ�̵߳ȴ�  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        this.notify();//�����ڴ˶���������ϵȴ��ĵ����̣߳����������߳�  
        stb[index] = sb;  
        this.index++;  
    }  
      
    //�ӿ����ó����൱�ڳ�ջ  
    public synchronized SteamBread pop(){  
        while(index==0){//����ˣ���ջ��  
            try {  
                this.wait();  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        this.notify();  
        this.index--;//push��n��֮��this.index++��ʹջ��Ϊn+1����return֮ǰҪ��һ  
        return stb[index];  
    }  
}  
  
//�������࣬ʵ����Runnable�ӿڣ��Ա��ڹ����������߳�  
class Producer implements Runnable{  
    SyncStack ss = null;  
    Producer(SyncStack ss){  
        this.ss = ss;  
    }  
    @Override  
    public void run() {  
        // ��ʼ������ͷ  
        for(int i=0;i<20;i++){  
            SteamBread stb = new SteamBread(i);  
            ss.push(stb);  
            System.out.println("������"+stb);  
            try {  
                Thread.sleep(10);//ÿ����һ����ͷ��˯��10����  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
//�������࣬ʵ����Runnable�ӿڣ��Ա��ڹ����������߳�  
class Consume implements Runnable{  
    SyncStack ss = null;  
    public Consume(SyncStack ss) {  
        super();  
        this.ss = ss;  
    }  
    @Override  
    public void run() {  
        // TODO Auto-generated method stub  
        for(int i=0;i<20;i++){//��ʼ������ͷ  
            SteamBread stb = ss.pop();  
            System.out.println("������"+stb);  
            try {  
                Thread.sleep(100);//ÿ����һ����ͷ��˯��100���롣���������������һ��  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }     
}