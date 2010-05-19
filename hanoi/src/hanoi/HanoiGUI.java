package hanoi;
import java.awt.*;
import java.awt.event.*;
/***********************************************************************************
 * 
 * @author william ma
 * ��ŵ����ʾС���򣬽����ṩ20�����ӣ�̫���˵Ļ�����Ļ�Ų��£����ڽ�����ʾ����20�����ӣ�
 * ���⣬20���Ļ�ʱ��Ƚϳ����Ƽ�10�ͺ���1023�������������ÿ���ٶȡ�
 ***********************************************************************************/
public class HanoiGUI extends Frame implements ItemListener,Runnable{
	private static final long serialVersionUID = 1L;
	static int j=0;        //��¼�ᶯ�Ĵ���
    static int n=1;           //��ʼ�����Ӹ���Ϊ1
    static int delay=20;       //��ʾ��ʱ������Ϊ����
    
    //���ӵĸߣ�20
    static int towerAy=545;       //A��������һ�����ӵ�������
    static int towerBy=545;       //B��������һ�����ӵ�������
    static int towerCy=545;       //C��������һ�����ӵ�������
    
    static HanoiGUI frame = new HanoiGUI();    //�������ڶ���
    static Thread thread = new Thread(frame);    //����һ���߳�
    static Label lab1=new Label("�������Ӹ�����1~20��");  
    static TextField txt1=new TextField(10);  
    
    static Label lab2=new Label("��ʾ�ٶ�");
    static Checkbox ckb1=new Checkbox("��");       
    static Checkbox ckb2=new Checkbox("��");
    static Checkbox ckb3=new Checkbox("��");
    
    static Button initBtn = new Button("����������");
    static Button startBtn=new Button("��ʾ");
    static Button pauseBtn=new Button("��ͣ");
    static Button goOnBtn=new Button("����");
    static Button exitBtn=new Button("�˳�");
    static Button renewBtn=new Button("����"); 
    
    static Label labTxt=new Label("��¼�ƶ�����");
    static TextArea ta=new TextArea();
     
    static Button btnDisk[]=new Button[20];    //ʹ�ð�ť�����ӣ����20����

    public static void main(String args[]){
    	CheckboxGroup grp=new CheckboxGroup();  //������ѡ����     

    	ckb1.setCheckboxGroup(grp);     
    	ckb2.setCheckboxGroup(grp);
    	ckb3.setCheckboxGroup(grp);

    	ckb1.addItemListener(frame);     
    	ckb2.addItemListener(frame);
    	ckb3.addItemListener(frame);

    	frame.setResizable(false);     
    	frame.setLayout(null);
    	frame.setTitle("��ŵ����ʾϵͳ");
    	frame.setSize(1050,600);
    	frame.setBackground(Color.YELLOW);
      
    	//��ʼ���б�ǩ����ť���ı��򣬵�ѡ���λ��
    	lab1.setBounds(20,560,150,15);    
    	txt1.setBounds(150,560,20,15);
    	lab2.setBounds(20,580,60,15);
    	ckb1.setBounds(90,580,30,15);
    	ckb2.setBounds(120,580,30,15);
    	ckb3.setBounds(150,580,30,15);
      
    	initBtn.setBounds(200, 560, 110, 29);
    	startBtn.setBounds(340,560,110,29);
    	pauseBtn.setBounds(490,560,110,29);
    	goOnBtn.setBounds(490,560,110,29);
    	exitBtn.setBounds(650,560,110,29);
    	renewBtn.setBounds(340,560,110,29);
      
    	labTxt.setBounds(850, 45,120,30);     
    	ta.setBounds(820,75,180,470);
      

    	//��ӱ�ǩ����ť���ı��򣬵�ѡ�򵽴���
    	frame.add(txt1);        
    	frame.add(lab1);
    	frame.add(lab2);

    	frame.add(initBtn);
    	frame.add(startBtn);
    	frame.add(pauseBtn);
    	frame.add(goOnBtn);      
    	frame.add(exitBtn);
    	frame.add(renewBtn);
      
    	frame.add(ckb1);
    	frame.add(ckb2);
    	frame.add(ckb3);
      
    	frame.add(labTxt);
    	frame.add(ta);
    	frame.setVisible(true);
      
    	startBtn.setVisible(false);
    	pauseBtn.setVisible(false);
    	goOnBtn.setVisible(false);
    	renewBtn.setVisible(false);
      
    	frame.addWindowListener(new WindowAdapter(){  
    		public void windowClosing(WindowEvent e){
    			System.exit(0);          
    		}
    	});
      

    	pauseBtn.addActionListener(new ActionListener(){     
    		@SuppressWarnings("deprecation")
    		public void actionPerformed(ActionEvent e) {
    			thread.suspend();
    			pauseBtn.setVisible(false);
    			goOnBtn.setVisible(true);
    		}
    	});

      goOnBtn.addActionListener(new ActionListener(){
    	  @SuppressWarnings("deprecation")
    	  public void actionPerformed(ActionEvent e){
    		  goOnBtn.setVisible(false);
    		  pauseBtn.setVisible(true);
    		  thread.resume();                  
    	  }
      });
      
      exitBtn.addActionListener(new ActionListener(){     
          public void actionPerformed(ActionEvent e) {              
              thread.interrupt();
              System.exit(0);              
          }
        });
      
      initBtn.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  //�����������ݲ������֣���������쳣
    		  try{  
    			  n=Integer.parseInt(txt1.getText());
    		  }catch(NumberFormatException f){       
    			  return;
    		  }
    		
    		  if(n>0 && n<=20){   
    			  //��������쳣����
    			  towerAy=550;  //������ǰ�ָ�ԭ����������
    			  drawDisk();
    			  startBtn.setVisible(true);
    			  initBtn.setVisible(false);
    		  }
    	  }
      });
      
      startBtn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
        	  startBtn.setVisible(false);//���ؿ�ʼ��ť����ʾ�������á���ť
              pauseBtn.setVisible(true);             
              thread.start();        
              renewBtn.setVisible(true);   //��ʾ������ʾ���ð�ť
              initBtn.setVisible(false);
              txt1.setVisible(false);  //��ʾ���������ı��� 
          }
      });
      
      renewBtn.addActionListener(new ActionListener(){
    	  @SuppressWarnings("deprecation")
    	  public void actionPerformed(ActionEvent e){
              thread.stop();
              thread=new Thread(frame);  //���ú�ֹͣ���̣߳���ʹ�̴߳��ڴ���״̬             
              
              j=0;
              ta.setText(null);
              txt1.setText(null);
              renewBtn.setVisible(false);
              initBtn.setVisible(true);
              goOnBtn.setVisible(false);
              pauseBtn.setVisible(false);
              for(int i=0;i<=n-1;i++){
            	  frame.remove(btnDisk[i]); //�����������Ӵ�������
              }
              txt1.setVisible(true);             
              towerAy=550;
              towerBy=550;
              towerCy=550;
          }
      });  
      } 
 
    //����
    public void paint(Graphics g){     
        
        //��һ������
        g.drawRect(20, 545, 240, 5); 
        g.setColor(Color.BLACK);
        g.fillRect(20, 545, 240, 5);
        //��һ������
        g.drawRect(140, 45, 5, 500);
        g.setColor(Color.BLACK);
        g.fillRect(140, 45, 5, 500);
        //�ڶ�������
        g.drawRect(280, 545, 240, 5); 
        g.setColor(Color.BLACK);
        g.fillRect(280, 545, 240, 5);
        //�ڶ�������
        g.drawRect(400, 45, 5, 500); 
        g.setColor(Color.BLACK);
        g.fillRect(400, 45, 5, 500);
        
        //����������
        g.drawRect(540, 545, 240, 5); 
        g.setColor(Color.BLACK);
        g.fillRect(540, 545, 240, 5);
        
        //����������
        g.drawRect(660, 45, 5, 500); 
        g.setColor(Color.BLACK);
        g.fillRect(660, 45, 5, 500);
    }
 
    //������
    public static void drawDisk(){
         for(int i=0;i<n;i++){
             btnDisk[i]=new Button(Integer.toString(i+1));            
             btnDisk[i].setSize(12*(i+1),20);
             btnDisk[i].setLocation(140-btnDisk[i].getWidth()/2,550-btnDisk[i].getHeight()*(n-i));
             btnDisk[i].setBackground(Color.RED);
             frame.add(btnDisk[i]);            
         }
         towerAy=towerAy-20*n;  //�ı�������
    }
 
    //������ʾ�������ƶ��ٶ�
    public void itemStateChanged(ItemEvent e){   
    	if(ckb1.getState()==true){
    		delay=5;
    	}
    	if(ckb2.getState()==true){
    		delay=10;
    	}
    	if(ckb3.getState()==true){
    		delay=21;
    	}
    }

    /*******************************************************************************************
     * ��һ��ѭ�����ӻ����ӵ��ƶ��ٶ�
     *******************************************************************************************/
    public void delay(int time){  
    	double m;
    	for(m=1;m<=Math.pow(2,(double)time);m++);         
    } 

    /*******************************************************************************************
     * ��ŵ����ʾ�ĺ��ĳ���,�ݹ�ʵ��
     *******************************************************************************************/
    public void hanoi(Button labelDisk[],int nc,int xc,int yc,int zc){  
    	if(nc==1){
        	 delay(delay);  
             move(labelDisk,xc,1,zc);   //��ֻ��һ������ʱֱ�Ӵ�ԭ���ƶ���Ŀ����
             delay(delay);               
         }else{    
             hanoi(labelDisk,nc-1,xc,zc,yc);//����N������ʱ���Ȱ�����N-1�������ƶ���������������              
             delay(delay);
             move(labelDisk,xc,nc,zc);  //�ƶ���N�����ӵ�Ŀ����
             delay(delay);             
             hanoi(labelDisk,nc-1,yc,xc,zc);//��ʣ�µ�N-1�����ӴӸ����������ƶ���Ŀ����
         }      
     }
    /*******************************************************************************************
     * �ƶ�������
     * xb,zb�ֱ����е��������� 
     * nb��ʾ������ 
     *******************************************************************************************/
     public void move(Button labb[],int xb,int nb,int zb){ 
    	 //��¼�ᶯ�Ĵ���
    	 j++;    
         
         //�������ӣ�������ϵ�����������ٶ���һ��Ϊԭ�����ڶ�ΪĿ����
    	 //AC�������
    	 if(xb==140&&zb==660){
             labb[nb-1].setLocation(660-labb[nb-1].getWidth()/2,towerCy-20);
             towerAy=towerAy+20;//��ԭ������һ�����Ӻ�ԭ��������������ӵ�������
             towerCy=towerCy-20;//Ŀ�����õ�һ�����Ӻ�Ŀ����������������ӵ������� 
             //int i=nb;
             ta.append("��"+j+"��������"+nb+"��A���Ƶ�C��\n");
             //ÿ�岽���һ���س�
             if(j%5==0){    
                 ta.append("\n");
             }             
         }
    	 //AB�������
         if(xb==140&&zb==400){
             labb[nb-1].setLocation(400-labb[nb-1].getWidth()/2,towerBy-20);
             towerAy=towerAy+20;
             towerBy=towerBy-20;
            
             ta.append("��"+j+"��������"+nb+"��A���Ƶ�B��\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }

         //BC�������
         if(xb==400&&zb==660){
             labb[nb-1].setLocation(660-labb[nb-1].getWidth()/2,towerCy-20);
             towerBy=towerBy+20;
             towerCy=towerCy-20; 
             
             ta.append("��"+j+"��������"+nb+"��B���Ƶ�C��\n");
             if(j%5==0){    
                 ta.append("\n");
             }            
         }
         
         //BA�������
         if(xb==400&&zb==140){
             labb[nb-1].setLocation(140-labb[nb-1].getWidth()/2,towerAy-20);
             towerBy=towerBy+20;
             towerAy=towerAy-20;
             
             ta.append("��"+j+"��������"+nb+"��B���Ƶ�A��\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }

         //CB�������
         if(xb==660&&zb==400){
             labb[nb-1].setLocation(400-labb[nb-1].getWidth()/2,towerBy-20);
             towerCy=towerCy+20;
             towerBy=towerBy-20;
            
             ta.append("��"+j+"��������"+nb+"��C���Ƶ�B��\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }
         
          if(xb==660&&zb==140){//����һ�������
             labb[nb-1].setLocation(140-labb[nb-1].getWidth()/2,towerAy-20);
             towerCy=towerCy+20;
             towerAy=towerAy-20;
             
             ta.append("��"+j+"��������"+nb+"��C���Ƶ�A��\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }
     }
     public void run(){
         hanoi(btnDisk,n,140,400,660);        
     }
}
