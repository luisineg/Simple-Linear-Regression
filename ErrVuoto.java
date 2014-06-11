import java.awt.*;
import java.awt.event.*;

public class ErrVuoto extends Frame{

	public static final long serialVersionUID=1L;
	
	public static void main(String args[]){
		ErrVuoto istVuoto = new ErrVuoto();
	}
	
	ErrVuoto(){
		setBounds(570,500,600,400);
		Panel testo=new Panel(new GridLayout(1,1,3,3));
		Panel button=new Panel();
		setTitle(getClass().getName());
		
		testo.add(new Label("Error: you have not entered value.",Label.CENTER));
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
