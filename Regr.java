import java.awt.*;
import java.awt.event.*;

public class Regr extends Frame{
	
	private static final long serialVersionUID=1L;
	private TextField t1;
	private TextField t2;
	
	public static void main(String args[]){
		Regr ist = new Regr();
	}
	Regr(){
		setBounds(250,250,600,400);
		Panel ptesto=new Panel(new GridLayout(0,1,3,3));
		Panel pbottoni=new Panel();
		setTitle(getClass().getName());
		
		ptesto.add(new Label("First:",Label.LEFT));
		ptesto.add(new Label("1-Insert  at least two values,",Label.LEFT));
		ptesto.add(new Label("not less than two.",Label.LEFT));
		ptesto.add(new Label("How many values of x?",Label.LEFT));
		ptesto.add(t1=new TextField(""));
		ptesto.add(new Label("How many values of y?",Label.LEFT));
		ptesto.add(t2=new TextField(""));
		
		pbottoni.setLayout(new FlowLayout());
		((Button)pbottoni.add(new Button("Go"))).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					int x=Integer.parseInt(t1.getText());
					int y=Integer.parseInt(t2.getText());
					if(x!=y){
						new ErrDisegual();
					}
					else{
						if(x<2||y<2){
							new ErrMeno();
						}
						else{
							t1.setText("");
							t2.setText("");
							new Regr2(x,y);
						}
					}
				}
				catch(Exception ex){
					new ErrEXC();
				}
			}
		});
		((Button)pbottoni.add(new Button("Exit"))).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		ptesto.add(new Label("Created by Simone Negro",Label.LEFT));
		ptesto.add(new Label("simonenegro1@gmail.com",Label.LEFT));
	
		add(ptesto,"Center");
		add(pbottoni,"South");
		pack();
		setVisible(true);
	}
}
