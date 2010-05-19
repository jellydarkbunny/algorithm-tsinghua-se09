package hanoi;
import java.awt.*;
import java.awt.event.*;
/***********************************************************************************
 * 
 * @author william ma
 * 汉诺塔演示小程序，仅仅提供20个盘子，太多了的话，屏幕放不下，由于仅供演示，故20个足矣，
 * 此外，20个的话时间比较长，推荐10就好了1023步就能做到。用快的速度。
 ***********************************************************************************/
public class HanoiGUI extends Frame implements ItemListener,Runnable{
	private static final long serialVersionUID = 1L;
	static int j=0;        //记录搬动的次数
    static int n=1;           //初始化盘子个数为1
    static int delay=20;       //演示的时间设置为中速
    
    //盘子的高：20
    static int towerAy=545;       //A塔最上面一个盘子的纵坐标
    static int towerBy=545;       //B塔最上面一个盘子的纵坐标
    static int towerCy=545;       //C塔最上面一个盘子的纵坐标
    
    static HanoiGUI frame = new HanoiGUI();    //创建窗口对象
    static Thread thread = new Thread(frame);    //创建一个线程
    static Label lab1=new Label("输入盘子个数（1~20）");  
    static TextField txt1=new TextField(10);  
    
    static Label lab2=new Label("演示速度");
    static Checkbox ckb1=new Checkbox("快");       
    static Checkbox ckb2=new Checkbox("中");
    static Checkbox ckb3=new Checkbox("慢");
    
    static Button initBtn = new Button("设置盘子数");
    static Button startBtn=new Button("演示");
    static Button pauseBtn=new Button("暂停");
    static Button goOnBtn=new Button("继续");
    static Button exitBtn=new Button("退出");
    static Button renewBtn=new Button("重置"); 
    
    static Label labTxt=new Label("记录移动过程");
    static TextArea ta=new TextArea();
     
    static Button btnDisk[]=new Button[20];    //使用按钮做盘子，最多20个盘

    public static void main(String args[]){
    	CheckboxGroup grp=new CheckboxGroup();  //创建单选框组     

    	ckb1.setCheckboxGroup(grp);     
    	ckb2.setCheckboxGroup(grp);
    	ckb3.setCheckboxGroup(grp);

    	ckb1.addItemListener(frame);     
    	ckb2.addItemListener(frame);
    	ckb3.addItemListener(frame);

    	frame.setResizable(false);     
    	frame.setLayout(null);
    	frame.setTitle("汉诺塔演示系统");
    	frame.setSize(1050,600);
    	frame.setBackground(Color.YELLOW);
      
    	//初始所有标签，按钮，文本框，单选框的位置
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
      

    	//添加标签，按钮，文本框，单选框到窗口
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
    		  //如果输入的内容不是数字，处理这个异常
    		  try{  
    			  n=Integer.parseInt(txt1.getText());
    		  }catch(NumberFormatException f){       
    			  return;
    		  }
    		
    		  if(n>0 && n<=20){   
    			  //对输入的异常处理
    			  towerAy=550;  //画盘子前恢复原来的纵坐标
    			  drawDisk();
    			  startBtn.setVisible(true);
    			  initBtn.setVisible(false);
    		  }
    	  }
      });
      
      startBtn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
        	  startBtn.setVisible(false);//隐藏开始按钮。显示出“重置“按钮
              pauseBtn.setVisible(true);             
              thread.start();        
              renewBtn.setVisible(true);   //演示结束显示重置按钮
              initBtn.setVisible(false);
              txt1.setVisible(false);  //演示结束隐藏文本框 
          }
      });
      
      renewBtn.addActionListener(new ActionListener(){
    	  @SuppressWarnings("deprecation")
    	  public void actionPerformed(ActionEvent e){
              thread.stop();
              thread=new Thread(frame);  //重置后，停止了线程，再使线程处于创建状态             
              
              j=0;
              ta.setText(null);
              txt1.setText(null);
              renewBtn.setVisible(false);
              initBtn.setVisible(true);
              goOnBtn.setVisible(false);
              pauseBtn.setVisible(false);
              for(int i=0;i<=n-1;i++){
            	  frame.remove(btnDisk[i]); //将产生的盘子从面板清空
              }
              txt1.setVisible(true);             
              towerAy=550;
              towerBy=550;
              towerCy=550;
          }
      });  
      } 
 
    //画塔
    public void paint(Graphics g){     
        
        //第一个塔底
        g.drawRect(20, 545, 240, 5); 
        g.setColor(Color.BLACK);
        g.fillRect(20, 545, 240, 5);
        //第一个塔柱
        g.drawRect(140, 45, 5, 500);
        g.setColor(Color.BLACK);
        g.fillRect(140, 45, 5, 500);
        //第二个塔底
        g.drawRect(280, 545, 240, 5); 
        g.setColor(Color.BLACK);
        g.fillRect(280, 545, 240, 5);
        //第二个塔柱
        g.drawRect(400, 45, 5, 500); 
        g.setColor(Color.BLACK);
        g.fillRect(400, 45, 5, 500);
        
        //第三个塔底
        g.drawRect(540, 545, 240, 5); 
        g.setColor(Color.BLACK);
        g.fillRect(540, 545, 240, 5);
        
        //第三个塔柱
        g.drawRect(660, 45, 5, 500); 
        g.setColor(Color.BLACK);
        g.fillRect(660, 45, 5, 500);
    }
 
    //画盘子
    public static void drawDisk(){
         for(int i=0;i<n;i++){
             btnDisk[i]=new Button(Integer.toString(i+1));            
             btnDisk[i].setSize(12*(i+1),20);
             btnDisk[i].setLocation(140-btnDisk[i].getWidth()/2,550-btnDisk[i].getHeight()*(n-i));
             btnDisk[i].setBackground(Color.RED);
             frame.add(btnDisk[i]);            
         }
         towerAy=towerAy-20*n;  //改变纵坐标
    }
 
    //设置演示中盘子移动速度
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
     * 用一个循环体延缓盘子的移动速度
     *******************************************************************************************/
    public void delay(int time){  
    	double m;
    	for(m=1;m<=Math.pow(2,(double)time);m++);         
    } 

    /*******************************************************************************************
     * 汉诺塔演示的核心程序,递归实现
     *******************************************************************************************/
    public void hanoi(Button labelDisk[],int nc,int xc,int yc,int zc){  
    	if(nc==1){
        	 delay(delay);  
             move(labelDisk,xc,1,zc);   //当只有一个盘子时直接从原柱移动到目的柱
             delay(delay);               
         }else{    
             hanoi(labelDisk,nc-1,xc,zc,yc);//当有N个盘子时，先把上面N-1个盘子移动到辅助的柱子上              
             delay(delay);
             move(labelDisk,xc,nc,zc);  //移动第N个盘子到目的柱
             delay(delay);             
             hanoi(labelDisk,nc-1,yc,xc,zc);//把剩下的N-1个盘子从辅助的柱子移动到目的柱
         }      
     }
    /*******************************************************************************************
     * 移动操作。
     * xb,zb分别其中的两个塔。 
     * nb表示盘子数 
     *******************************************************************************************/
     public void move(Button labb[],int xb,int nb,int zb){ 
    	 //记录搬动的次数
    	 j++;    
         
         //三个柱子，两两组合的六种情况。假定第一个为原柱，第二为目标柱
    	 //AC两塔组合
    	 if(xb==140&&zb==660){
             labb[nb-1].setLocation(660-labb[nb-1].getWidth()/2,towerCy-20);
             towerAy=towerAy+20;//从原柱移走一个盘子后，原柱的最上面的盘子的纵坐标
             towerCy=towerCy-20;//目的柱得到一个盘子后，目的柱的最上面的盘子的纵坐标 
             //int i=nb;
             ta.append("第"+j+"步，盘子"+nb+"从A塔移到C塔\n");
             //每五步输出一个回车
             if(j%5==0){    
                 ta.append("\n");
             }             
         }
    	 //AB两塔组合
         if(xb==140&&zb==400){
             labb[nb-1].setLocation(400-labb[nb-1].getWidth()/2,towerBy-20);
             towerAy=towerAy+20;
             towerBy=towerBy-20;
            
             ta.append("第"+j+"步，盘子"+nb+"从A塔移到B塔\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }

         //BC两塔组合
         if(xb==400&&zb==660){
             labb[nb-1].setLocation(660-labb[nb-1].getWidth()/2,towerCy-20);
             towerBy=towerBy+20;
             towerCy=towerCy-20; 
             
             ta.append("第"+j+"步，盘子"+nb+"从B塔移到C塔\n");
             if(j%5==0){    
                 ta.append("\n");
             }            
         }
         
         //BA两塔组合
         if(xb==400&&zb==140){
             labb[nb-1].setLocation(140-labb[nb-1].getWidth()/2,towerAy-20);
             towerBy=towerBy+20;
             towerAy=towerAy-20;
             
             ta.append("第"+j+"步，盘子"+nb+"从B塔移到A塔\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }

         //CB两塔组合
         if(xb==660&&zb==400){
             labb[nb-1].setLocation(400-labb[nb-1].getWidth()/2,towerBy-20);
             towerCy=towerCy+20;
             towerBy=towerBy-20;
            
             ta.append("第"+j+"步，盘子"+nb+"从C塔移到B塔\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }
         
          if(xb==660&&zb==140){//三、一两塔组合
             labb[nb-1].setLocation(140-labb[nb-1].getWidth()/2,towerAy-20);
             towerCy=towerCy+20;
             towerAy=towerAy-20;
             
             ta.append("第"+j+"步，盘子"+nb+"从C塔移到A塔\n");
             if(j%5==0){    
                 ta.append("\n");
             }             
         }
     }
     public void run(){
         hanoi(btnDisk,n,140,400,660);        
     }
}
