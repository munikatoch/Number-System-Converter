import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Convert implements ActionListener {
	JFrame f;
	JButton jb;
	ButtonGroup bg1, bg2;
	JRadioButton b1, b2, b3, b4, b5, b6, b7, b8;
	JTextField tf1, tf2;
	String conv, val;

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {

		}
		Convert c = new Convert();
		c.createFrame();
	}

	void createFrame() {
		f = new JFrame("Unit Converter");
		jb = new JButton("Convert");
		b1 = new JRadioButton("Binary");
		b2 = new JRadioButton("Octal");
		b3 = new JRadioButton("Decimal");
		b4 = new JRadioButton("HexaDecimal");
		b5 = new JRadioButton("Binary");
		b6 = new JRadioButton("Octal");
		b7 = new JRadioButton("Decimal");
		b8 = new JRadioButton("HexaDecimal");
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		tf1 = new JTextField();
		tf2 = new JTextField();
		jb.setBounds(225, 450, 100, 40);
		b1.setBounds(75, 175, 100, 40);
		b2.setBounds(75, 225, 100, 40);
		b3.setBounds(75, 275, 100, 40);
		b4.setBounds(75, 325, 100, 40);
		b5.setBounds(300, 175, 100, 40);
		b6.setBounds(300, 225, 100, 40);
		b7.setBounds(300, 275, 100, 40);
		b8.setBounds(300, 325, 100, 40);
		tf1.setBounds(75, 75, 175, 30);
		tf2.setBounds(300, 75, 175, 30);
		jb.addActionListener(this);
		bg1.add(b1);
		bg1.add(b2);
		bg1.add(b3);
		bg1.add(b4);
		bg2.add(b5);
		bg2.add(b6);
		bg2.add(b7);
		bg2.add(b8);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(jb);
		f.add(tf1);
		f.add(tf2);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public boolean isBinary(String s) {
		int i, len = s.length(), count = 0;
		char c = s.charAt(0);
		if (c != '1' && c != '0')
			return false;
		for (i = 1; i < len; i++) {
			c = s.charAt(i);
			if ((c != '0' && c != '1' && c != '.') || count > 1)
				return false;
			if (c == '.')
				count++;
		}
		return true;
	}

	public boolean isOctal(String s) {
		int i, len = s.length(), count = 0;
		char c = s.charAt(0);
		if (!(c >= '0' && c <= '7'))
			return false;
		for (i = 1; i < len; i++) {
			c = s.charAt(i);
			if ((!(c >= '0' && c <= '7') && c != '.') || count > 1)
				return false;
			if (c == '.')
				count++;
		}
		return true;
	}

	public boolean isDecimal(String s) {
		int i, len = s.length(), count = 0;
		char c = s.charAt(0);
		if (!(c >= '0' && c <= '9'))
			return false;
		for (i = 1; i < len; i++) {
			c = s.charAt(i);
			if ((!(c >= '0' && c <= '9') && c != '.') || count > 1)
				return false;
			if (c == '.')
				count++;
		}
		return true;
	}

	public boolean isHexaDecimal(String s) {
		int i, len = s.length(), count = 0;
		char c = s.charAt(0);
		if (c >= 'a' && c <= 'f')
			c = Character.toUpperCase(c);
		if (!(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'F'))
			return false;
		for (i = 1; i < len; i++) {
			c = s.charAt(i);
			if (c >= 'a' && c <= 'f')
				c = Character.toUpperCase(c);
			if ((!(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'F') && c != '.') || count > 1)
				return false;
			if (c == '.')
				count++;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Convert c = new Convert();
		conv = tf1.getText();
		if (b1.isSelected() && !conv.equals("") && c.isBinary(conv)) {
			if (b5.isSelected()) {
				tf2.setText(conv);
			} else if (b6.isSelected()) {
				val = c.toDecimal(conv, 2);
				conv = c.toOther(val, 8);
				tf2.setText(conv);
			} else if (b7.isSelected()) {
				val = c.toDecimal(conv, 2);
				tf2.setText("" + val);
			} else if (b8.isSelected()) {
				val = c.toDecimal(conv, 2);
				conv = c.toOther(val, 16);
				tf2.setText(conv);
			} else {
				tf2.setText("Select an option");
			}
		} else if (b2.isSelected() && !conv.equals("") && c.isOctal(conv)) {
			if (b5.isSelected()) {
				val = c.toDecimal(conv, 8);
				conv = c.toOther(val, 2);
				tf2.setText(conv);
			} else if (b6.isSelected()) {
				tf2.setText(conv);
			} else if (b7.isSelected()) {
				val = c.toDecimal(conv, 8);
				tf2.setText("" + val);
			} else if (b8.isSelected()) {
				val = c.toDecimal(conv, 8);
				conv = c.toOther(val, 16);
				tf2.setText(conv);
			} else {
				tf2.setText("Select an option");
			}
		} else if (b3.isSelected() && !conv.equals("") && c.isDecimal(conv)) {
			if (b5.isSelected()) {
				conv = c.toOther(conv, 2);
				tf2.setText(conv);
			} else if (b6.isSelected()) {
				conv = c.toOther(conv, 8);
				tf2.setText(conv);
			} else if (b7.isSelected()) {
				tf2.setText(conv);
			} else if (b8.isSelected()) {
				conv = c.toOther(conv, 16);
				tf2.setText(conv);
			} else {
				tf2.setText("Select an option");
			}
		} else if (b4.isSelected() && !conv.equals("") && c.isHexaDecimal(conv)) {
			if (b5.isSelected()) {
				val = c.toDecimal(conv, 16);
				conv = c.toOther(val, 2);
				tf2.setText(conv);
			} else if (b6.isSelected()) {
				val = c.toDecimal(conv, 16);
				conv = c.toOther(val, 8);
				tf2.setText(conv);
			} else if (b7.isSelected()) {
				val = c.toDecimal(conv, 16);
				tf2.setText("" + val);
			} else if (b8.isSelected()) {
				tf2.setText(conv);
			} else {
				tf2.setText("Select an option");
			}
		} else {
			tf2.setText("Invalid selected format");
		}
	}

	public String toDecimal(String s, int radix) {
		String b = "";
		String[] n = s.split("[.]");
		b = Long.toString(Long.parseLong(n[0], radix));
		if (n.length == 2) {
			int len = n[1].length(), pos = 0, val;
			double sum = 0;
			if (len > 4)
				len = 4;
			long div = (long) (radix);
			while (pos < len) {
				if (n[1].charAt(pos) == 'A')
					val = 10;
				else if (n[1].charAt(pos) == 'B')
					val = 11;
				else if (n[1].charAt(pos) == 'C')
					val = 12;
				else if (n[1].charAt(pos) == 'D')
					val = 13;
				else if (n[1].charAt(pos) == 'E')
					val = 14;
				else if (n[1].charAt(pos) == 'F')
					val = 15;
				else
					val = (int) (n[1].charAt(pos) - '0');
				sum += (double) val / div;
				div *= radix;
				pos++;
			}
			sum += (double) Long.parseLong(b);
			b = Double.toString(sum);
		}
		return b;
	}

	public String toOther(String s, int div) {
		String b = "";
		String[] n = s.split("[.]");
		long l = Long.parseLong(n[0]), rem;
		while (l > 0) {
			rem = l % div;
			b = Long.toString(rem) + b;
			l /= div;
		}
		if (n.length == 2) {
			b += ".";
			double d = Double.parseDouble("."+n[1]);
			int len = 0;
			while (len < 4) {
				d *= div;
				rem = (long) d % 100;
				if (rem == 10)
					b += "A";
				else if (rem == 11)
					b += "B";
				else if (rem == 11)
					b += "C";
				else if (rem == 11)
					b += "D";
				else if (rem == 11)
					b += "E";
				else if (rem == 11)
					b += "F";
				else
					b += Long.toString(rem);
				d -= rem;
				if (d == 0)
					break;
				len++;
			}
		}
		return b;
	}
}
/*
 * public boolean isBinary(String s){ int i,len=s.length(),count=0; char
 * c=s.charAt(0); if(c!='1' && c!='0') return false; for(i=1;i<len;i++){
 * c=s.charAt(i); if((c!='0' && c!='1' && c!='.') || count>1) return false;
 * if(c=='.') count++; } return true; } public boolean isOctal(String s){ int
 * i,len=s.length(),count=0; char c=s.charAt(0); if(!(c>='0' && c<='7')) return
 * false; for(i=1;i<len;i++){ c=s.charAt(i); if((!(c>='0' && c<='7') && c!='.')
 * || count>1) return false; if(c=='.') count++; } return true; } public boolean
 * isDecimal(String s){ int i,len=s.length(),count=0; char c=s.charAt(0);
 * if(!(c>='0' && c<='9')) return false; for(i=1;i<len;i++){ c=s.charAt(i);
 * if((!(c>='0' && c<='9') && c!='.') || count>1) return false; if(c=='.')
 * count++; } return true; } public boolean isHexaDecimal(String s){ int
 * i,len=s.length(),count=0; char c=s.charAt(0); if(c>='a' && c<='f')
 * c=Character.toUpperCase(c); if(!(c>='0' && c<='9') && !(c>='A' && c<='F'))
 * return false; for(i=1;i<len;i++){ c=s.charAt(i); if(c>='a' && c<='f')
 * c=Character.toUpperCase(c); if((!(c>='0' && c<='9') && !(c>='A' && c<='F') &&
 * c!='.') || count>1) return false; if(c=='.') count++; } return true; } public
 * String toDecimal(String s, int radix){ String b=""; String []n= s.split(s);
 * b=Long.toString(Long.parseLong(n[0],radix)); if(n.length==2){ int
 * len=n[1].length(),pos=0,val; double sum=0; if(len>4) len=4; long div =
 * (long)(radix); while(pos<len){ if(n[1].charAt(pos)=='A') val=10; else
 * if(n[1].charAt(pos)=='B') val=11; else if(n[1].charAt(pos)=='C') val=12; else
 * if(n[1].charAt(pos)=='D') val=13; else if(n[1].charAt(pos)=='E') val=14; else
 * if(n[1].charAt(pos)=='F') val=15; else val=(int)(n[1].charAt(pos)-'0');
 * sum+=(double)val/div; div*=radix; pos++; } sum+=(double)Long.parseLong(b);
 * b=Double.toString(sum); } return b; } public String toOther(String s,int
 * div){ String b=""; String []n = s.split("."); long l =
 * Long.parseLong(n[0]),rem; while(l>0){ rem=l%div; b+=Long.toString(rem);
 * l/=div; } if(n.length==2){ b+="."; double d = Double.parseDouble(n[1]);
 * d*=0.1; int len=0; while(len<4){ d*=div; rem=(long)d/100; if(rem==10) b+="A";
 * else if(rem==11) b+="B"; else if(rem==11) b+="C"; else if(rem==11) b+="D";
 * else if(rem==11) b+="E"; else if(rem==11) b+="F"; else b+=Long.toString(rem);
 * d-=rem; if(d==0) break; len++; } } return b; }
 */