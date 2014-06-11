import java.awt.*;
import java.awt.event.*;

public class ErrNE extends Frame {
	
	private static final long serialVersionUID=1L;
	
	public static void main(String args[]){
		ErrNE istE = new ErrNE();
	}
	
	ErrNE(){
		setBounds(750,250,600,400);
		Panel testo=new Panel(new GridLayout(1,1,3,3));
		Panel button=new Panel();
		setTitle(getClass().getName());
		
		testo.add(new Label("Error: values not equal. Insert the same value.",Label.CENTER));
		button.setLayout(new FlowLayout());
		((Button)button.add(new Button("OK"))).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		add(testo,"North");
		add(button,"South");
		pack();
		setVisible(true);
	}
	
}
