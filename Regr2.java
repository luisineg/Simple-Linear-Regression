import java.awt.*;
import java.awt.event.*;

public class Regr2 extends Frame{
	
	public static final long serialVersionUID=1L;
	
	public static void main(String args[]){
		Regr2 ist2=new Regr2(0,0);
	}
	Regr2(final int x,final int y){
		setBounds(500,250,400,500);
		Panel b=new Panel(new GridLayout(0,1,2,2));
		final Panel c=new Panel(new GridLayout(0,1,2,2));
		final Panel pbot=new Panel();
		final Panel bot1=new Panel();
		final Panel bot2=new Panel();
		setTitle("Linear Regression");
		
		final TextField arrayx[]=new TextField[x];
		final TextField arrayy[]=new TextField[y];
		final double[] fieldx=new double[arrayx.length];
		final double[] fieldy=new double[arrayy.length];
	
		b.add(new Label("Values of x:",Label.LEFT));
		for(int i=0;i<x;i++){
			b.add(arrayx[i]=new TextField(""));
		}
		
		b.add(new Label("Values of y"));
		for(int i=0;i<y;i++){
			b.add(arrayy[i]=new TextField(""));
		}
		
		pbot.setLayout(new FlowLayout());
		((Button)pbot.add(new Button("Calculate"))).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(pbot);
				add(bot1,"South");
				for(int i=0;i<x;i++){
					arrayx[i].setEditable(false);
				}
				for(int j=0;j<y;j++){
					arrayy[j].setEditable(false);
				}
				try{
					for(int i=0;i<arrayx.length;i++){
						fieldx[i]=Double.parseDouble(arrayx[i].getText());
						fieldy[i]=Double.parseDouble(arrayy[i].getText());
					}
				}
				catch(Exception exc){
					new ErrEXC();
					setVisible(false);
					new Regr2(x,y);
				}
								
				c.add(new Label("X average = "+ XAverage(fieldx),Label.LEFT));
				c.add(new Label("Y average = "+ XAverage(fieldy),Label.LEFT));
				c.add(new Label("Summation (X[i]-XAverage)*(Y[i]-YAverage) = "+ XimXperYimY(fieldx,fieldy)));
				c.add(new Label("Value of a1 = "+ CalculateAone(fieldx,fieldy),Label.LEFT));
				c.add(new Label("Value of a0 = "+ CalculateAzero(fieldx,fieldy),Label.LEFT));
				c.add(new Label("Linear Regression equation is y = mx + q",Label.LEFT));
				c.add(new Label("Value of m = "+ CalculateM(fieldx,fieldy),Label.LEFT));
				c.add(new Label("Value of q = "+ CalculateQ(fieldx,fieldy),Label.LEFT));
				c.add(new Label("So the linear regression equation is: y = "+ CalculateM(fieldx,fieldy) +"x + "+ CalculateQ(fieldx,fieldy),Label.LEFT));
				c.add(new Label("If you want to calculate y with a specific value of x insert the value",Label.LEFT));
				final TextField rx;
				c.add(rx=new TextField(""));
				
				((Button)bot1.add(new Button("Restart"))).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						setVisible(false);
					}	
				});
				((Button)bot1.add(new Button("Calculate Y"))).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(rx.getText().isEmpty()){
							new ErrVuoto();
						}
						else{
							boolean controlla=true;
							if(controlla==true){
								try{
									Double.parseDouble(rx.getText());
									controlla=false;

									remove(bot1);
									add(bot2,"South");
									double val = Double.parseDouble(rx.getText());
									c.add(new Label("The value of y with x = "+ val +" is : "+ CalculateLineX(fieldx,fieldy,val)));

									((Button)bot2.add(new Button("Restart"))).addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e){
											setVisible(false);
										}
									});
									((Button)bot2.add(new Button("Exit"))).addActionListener(new ActionListener (){
										public void actionPerformed(ActionEvent e){
											System.exit(0);
										}
									});
									pack();
								}
								catch(Exception excp){
									controlla=true;
									new ErrVuoto();
								}
							}
						}
					}
				});
				((Button)bot1.add(new Button("Exit"))).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});
				pack();
			}
		});
		((Button)pbot.add(new Button("Exit"))).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		b.add(new Label("NaN is 'Not A Number',",Label.WIDTH));
		b.add(new Label("i.e. undefined result.",Label.WIDTH));
		b.add(new Label("Created by Simone Negro",Label.LEFT));
		b.add(new Label("simonenegro1@gmail.com",Label.LEFT));

		add(b,"West");
		add(c,"Center");
		add(pbot,"South");
		pack();
		setVisible(true);
	}
	public static double XAverage(double[] Xmed){
		double medio=0;
		double sum=0;
		for(int i=0;i<Xmed.length;i++){
			sum += Xmed[i];
		}
		medio=sum/(Xmed.length);
		return medio;
	}
	public static double[] XminusXAverage(double[] Xarray){
		double XAverage = XAverage(Xarray);
		double[] XminusXAverage = new double[Xarray.length];
		for(int i=0;i<Xarray.length;i++){
			XminusXAverage[i]= Xarray[i]-XAverage;
		}
		return XminusXAverage;
		}
	public static double XminusXAvSquare(double[] array){
		double XAverage = XAverage(array);
		double sommatoria = 0;
		for(int i=0;i<array.length;i++){
			sommatoria += (array[i] - XAverage)*(array[i] - XAverage);
		}
		return sommatoria;
	}
	public static double XimXperYimY(double[] array1,double[] array2){
		double XAverage = XAverage(array1);
		double YAverage = XAverage(array2);
		double sommatoria=0;
		for(int i=0;i<array1.length;i++){
			sommatoria += (array1[i] - XAverage)*(array2[i] - YAverage);
		}
		return sommatoria;
	}
	public static double CalculateAone(double[] x,double[] y){
		double a1 = (XimXperYimY(x,y))/(XminusXAvSquare(x));
		return a1;
	}
	public static double CalculateAzero(double[] x, double[] y){
		double a1 = CalculateAone(x,y);
		double XAverage = XAverage(x);
		double YAverage = XAverage(y);
		double a0 = YAverage - (a1 * XAverage);
		return a0;
	}
	public static double XiYimXmYm(double[] x,double[] y){
		double XAverage = XAverage(x);
		double YAverage = XAverage(y);
		double[] XiYimXmYm = new double[x.length];
		double sommatoria=0;
		for(int i=0; i<x.length;i++){
			XiYimXmYm[i] = (x[i]*y[i])-(XAverage*YAverage);;
		}
		for(int j=0;j<XiYimXmYm.length;j++){
			sommatoria += XiYimXmYm[j];
		}
		return sommatoria;
	}
	public static double CalculateM(double[] x,double[] y){
		double lunghezza = x.length;	
		double covarianza = ((1/lunghezza)*XiYimXmYm(x,y));
		double scarto = (XminusXAvSquare(x));
		double m=(covarianza/scarto);
		return m;
	}
	public static double CalculateQ(double[] x,double[] y){
		double q=XAverage(y)-(CalculateM(x,y)*XAverage(x));
		return q;
	}
	public static double CalculateLineX(double[] x,double[] y,double ValoreX){
		double ValoreRetta = (CalculateM(x,y)*ValoreX)+CalculateQ(x,y);
		return ValoreRetta;
	}  
}
