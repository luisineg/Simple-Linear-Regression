import java.awt.*;
import java.awt.event.*;

public class ErrMeno extends Frame {
	
	private static final long serialVersionUID=1L;

	public static void main(String args[]){
		ErrMeno errm=new ErrMeno();
	}
	
	ErrMeno(){
		setBounds(750,250,600,400);
		Panel testo=new Panel(new GridLayout(1,1,3,3));
		Panel button=new Panel();
		setTitle(getClass().getName());
		
		testo.add(new Label("Error: you have entered less than two value.",Label.CENTER));
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
