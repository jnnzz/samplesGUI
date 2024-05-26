/*
 * NAME: JAN LORENZ L. LAROCO
 * DATE: MARCH 29,2024
 * DESCRIPTION: MIDTERM PROJECT CALCULATOR/CONVERSION
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

  //DEC TO BINARY
  class Binary{ 
    int num;

    String displayBinary() {
      String binaryString = "";
      int temp = num; 
      int[] bin = new int[20]; 
      int counter = 0;
  
      while (temp > 0) {
          bin[counter] = temp % 2;
          temp = temp / 2;
          counter++;
      }
  
      for (int i = counter - 1; i >= 0; i--) {
          System.out.print(bin[i]);
          binaryString += bin[i]; 
      }
      return binaryString;
  }
  }

  //DEC TO HEX
  class Hex{
    int num;

    String displayHex() {
      StringBuilder hexString = new StringBuilder();
      char[] hexArray = new char[20];
      int counter = 0;
  
      while (num > 0) {
          hexArray[counter] = num % 16 == 10 ? 'A' :
                  num % 16 == 11 ? 'B' :
                  num % 16 == 12 ? 'C' :
                  num % 16 == 13 ? 'D' :
                  num % 16 == 14 ? 'E' :
                  num % 16 == 15 ? 'F' :
                  (char) (num % 16 + 48);
          num = num / 16;
          counter++;
      }
      for (int i = counter - 1; i >= 0; i--) {
          hexString.append(hexArray[i]);
      }
      System.out.println(hexString.toString()); 
      return hexString.toString();
  }    
  }
  
  //DEC TO OCTAL
  class Octal{ 
    int num;

    String displayOctal() {
      String octalString = "";
      int temp = num; 
      int[] bin = new int[20]; 
      int counter = 0;
  
      while (temp > 0) {
          bin[counter] = temp % 8;
          temp = temp / 8;
          counter++;
      }
  
      for (int i = counter - 1; i >= 0; i--) {
          System.out.print(bin[i]);
          octalString += bin[i]; 
      }
      return octalString;
  }
}

//ForFrame
class midtermsCalcu extends JFrame implements ActionListener {

    //FOR CALCULATOR VARIABLES
    JTextField text = new JTextField();
    JLabel note = new JLabel();
    JButton[] buttons = new JButton[10];
    JButton[] funcButtons = new JButton[10];
    JButton blank, add, sub, mul, div, deci, equa, del, clr, modu;
    ImageIcon image;
    JPanel panel;

    //FOR CONVERSION VARIABLES
    JTextField text1 = new JTextField();
    JButton conversion = new JButton("Go to Conversions"); 
    ImageIcon image1;
    JPanel panel1 = new JPanel();
    JPanel panel2= new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JButton convResult = new JButton("Result"); 
    JLabel noteConversion = new JLabel("Decimal to binary, hexadecimal, and octal Converter");
    JLabel noteNum = new JLabel("Input positive number to convert");
    char operator;
    double num1 = 0, 
           num2 = 0, 
           result = 0;

    Font font = new Font("New times roman",Font.PLAIN,22);
    Font funcFont = new Font("New times roman", Font.BOLD, 13);
    Font fontResult = new Font("New times roman", Font.BOLD, 23);
    
           
    midtermsCalcu() {

        //PANEL
        panel = new JPanel();
        panel.setBounds(40,140,300,350);
        panel.setLayout(new GridLayout(5,4));
        panel.setBackground(Color.black);

        //FuncButtons
        blank = new JButton();
        blank.setEnabled(false);
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("/");
        deci = new JButton(".");
        equa = new JButton("=");
        del = new JButton("Delete");
        clr = new JButton("Clear");
        modu = new JButton("%");

        blank.setBackground(Color.WHITE);
        add.setBackground(Color.ORANGE);
        sub.setBackground(Color.ORANGE);
        mul.setBackground(Color.ORANGE);
        div.setBackground(Color.ORANGE);
        deci.setBackground(Color.ORANGE);
        modu.setBackground(Color.ORANGE);
        equa.setBackground(Color.WHITE);
        clr.setBackground(Color.lightGray);
        del.setBackground(Color.lightGray);

        funcButtons[0]= blank;
        funcButtons[1]= add;
        funcButtons[2]= sub;
        funcButtons[3]= mul;
        funcButtons[4]= div;
        funcButtons[5]= deci;
        funcButtons[6]= equa;
        funcButtons[7]= del;
        funcButtons[8]= clr;
        funcButtons[9]= modu;

        //for-FuncButtons
        for (int i = 0; i < funcButtons.length; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setBounds(0, 0, 25, 25);
            funcButtons[i].setFocusable(false);
            funcButtons[i].setFont(funcFont);
        }
                
        //for-Buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(i)); 
            buttons[i].addActionListener(this);
            buttons[i].setBounds(0, 0, 25, 25);
            buttons[i].setFocusable(false);
            buttons[i].setFont(font);
        }

        //Display
        del.setBounds(40,500, 150, 50);
        clr.setBounds(190,500, 150, 50);
        panel.add(blank);
        panel.add(del);
        panel.add(clr);
        panel.add(modu);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(add);
        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);
        panel.add(sub);
        panel.add(buttons[7]);
        panel.add(buttons[8]);
        panel.add(buttons[9]);
        panel.add(mul);
        panel.add(deci);
        panel.add(buttons[0]);
        panel.add(equa);
        panel.add(div);

        //LABEL(note)
        note.setText("Calculate only 2 numbers");
        note.setBounds(40, 110, 300, 30); 
        note.setFont(new Font("New times roman", Font.PLAIN, 15)); 
        note.setForeground(Color.GRAY);

        //TEXTFIELD
        text.setBounds(40,40, 300, 70);;
        text.setEditable(false);
        text.setFont(font);

        //IMG
        image = new ImageIcon("calcc.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        //END OF CALCULATOR

        //STAR FOR CONVERSION CALC
        conversion.setBounds(90, 510, 200, 50);
        conversion.setFocusable(false);
        conversion.addActionListener(this);
        conversion.setBackground(Color.LIGHT_GRAY);
        conversion.setFont(new Font("New times roman", Font.BOLD, 17));
        conversion.setForeground(new Color(0, 0, 128));

        //text1
        text1.setBounds(40,90, 300, 70);;
        text1.setEditable(true);
        text1.setFont(font);
        
        //result
        convResult.setBounds(120,180, 150, 50);
        convResult.setFocusable(false);
        convResult.setFont(fontResult);
        convResult.addActionListener(this);

        //note
        noteConversion.setBounds(20, 10, 350, 50); 
        noteConversion.setFont(new Font("New times roman", Font.PLAIN, 15)); 
        noteConversion.setForeground(Color.ORANGE);

        noteNum.setBounds(40, 50, 350, 50); 
        noteNum.setFont(new Font("New times roman", Font.PLAIN, 15)); 
        noteNum.setForeground(Color.gray);

        //FRAME
        this.setTitle("Calculator and Conversions");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 620);
        this.setLayout(null);
        this.add(conversion);
        this.add(note);
        this.add(text);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
    }

    //MAIN 
    public static void main(String[] args) {
        new midtermsCalcu();  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //buttons
      for (int i=0; i<10; i++){
          if(e.getSource() == buttons[i]){
            text.setText(text.getText().concat(String.valueOf(i)));
          }
      }
      //forDecimal
      if (e.getSource() == deci){
          text.setText(text.getText().concat("."));
      }
      //forAdd
      if (e.getSource() == add){
        num1 = Double.parseDouble(text.getText());
        operator = '+';
        text.setText("");
      }
      //forSubtract
      if (e.getSource() == sub){
        if (text.getText().isEmpty() || text.getText().equals("-")) {
          text.setText("-");
          } else {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
          }
      }
      //forMultiply
      if (e.getSource() == mul){
        num1 = Double.parseDouble(text.getText());
        operator = 'x';
        text.setText("");
      }
      //forDivide
      if (e.getSource() == div){
        num1 = Double.parseDouble(text.getText());
        operator = '/';
        text.setText("");
      }
      //forModulo
      if (e.getSource() == modu){
        num1 = Double.parseDouble(text.getText());
        operator = '%';
        text.setText("");
      }
      //forEqual
      if (e.getSource() == equa){
        num2 = Double.parseDouble(text.getText());

        switch (operator) {
          case '+': result = num1 + num2;
                  break;
          case '-': result = num1 - num2;
                  break;
          case 'x': result = num1 * num2;
                  break;
          case '/': result = num1 / num2;
                  break;
          case '%': result = num1 % num2;
                  break;
        }
        text.setText(String.valueOf(result));
        num1 = result;
      }
      //forClear
      if (e.getSource() == clr){
        text.setText("");
      }
      //forDelete
      if (e.getSource() == del){
        String string = text.getText();
        text.setText("");
        for (int i=0; i<string.length()-1; i++){
          text.setText(text.getText()+string.charAt(i));
        }
      }
      //END FOR CALCULATOR

      //START FOR CONVERSION
      if (e.getSource() == conversion) {
      conversion.setEnabled(true);
      JFrame conversionFrame = new JFrame("Conversion");

      conversionFrame.setSize(400, 620);
      conversionFrame.setLayout(null);
      conversionFrame.setResizable(false);
      conversionFrame.getContentPane().setBackground(Color.DARK_GRAY);
      conversionFrame.add(noteConversion);
      conversionFrame.add(noteNum);
      conversionFrame.add(text1);
      conversionFrame.add(panel1);
      conversionFrame.add(panel2);
      conversionFrame.add(panel3);
      conversionFrame.add(convResult);
      conversionFrame.setVisible(true);
      image1 = new ImageIcon("calcc.png");
      conversionFrame.setIconImage(image.getImage());
      }

      //LISTENER FOR BINARY
      if (e.getSource() == convResult) {
        String input = text1.getText();

        if (!input.isEmpty()) {
            double decimalNumber = Double.parseDouble(input);
            Binary binaryConverter = new Binary();
            binaryConverter.num = (int) decimalNumber;
            

            JLabel textBinary = new JLabel();
            textBinary.setText("The binary is: ");
            textBinary.setForeground(Color.WHITE);
            textBinary.setFont(font);
            textBinary.setHorizontalAlignment(JLabel.CENTER);
            textBinary.setVerticalAlignment(JLabel.CENTER);

            JLabel binaryLabel = new JLabel();
            binaryLabel.setText(binaryConverter.displayBinary());
            binaryLabel.setForeground(Color.WHITE);
            binaryLabel.setFont(font);
            binaryLabel.setHorizontalAlignment(JLabel.CENTER);
            binaryLabel.setVerticalAlignment(JLabel.CENTER);

            if (decimalNumber == 0) {
                  binaryLabel.setText("0");
            }
            if (decimalNumber <0) {
              JOptionPane.showMessageDialog(null, "Please input positive number");
            }

            panel1.setBounds(40,250,300,100);
            panel1.setBackground(new Color(47, 79, 79));
            panel1.removeAll(); 
            panel1.setLayout(new GridLayout(2,1));
            panel1.add(textBinary);
            panel1.add(binaryLabel);
            panel1.revalidate(); 
            panel1.repaint(); 
        } 
      }
      //LISTENER FOR HEX
      if (e.getSource() == convResult) {
        String input = text1.getText();

        if (!input.isEmpty()) {
            double decimalNumber = Double.parseDouble(input);
            Hex hexConverter = new Hex();
            hexConverter.num = (int) decimalNumber;

            JLabel textHex = new JLabel();
            textHex.setText("The Hexadecimal is: ");
            textHex.setForeground(Color.WHITE);
            textHex.setFont(font);
            textHex.setHorizontalAlignment(JLabel.CENTER);
            textHex.setVerticalAlignment(JLabel.CENTER);

            JLabel hexLabel = new JLabel();
            hexLabel.setText(hexConverter.displayHex());
            hexLabel.setForeground(Color.WHITE);
            hexLabel.setFont(font);
            hexLabel.setHorizontalAlignment(JLabel.CENTER);
            hexLabel.setVerticalAlignment(JLabel.CENTER);

            if (decimalNumber == 0) {
                  hexLabel.setText("0");
            }

            panel2.setBounds(40, 350, 300, 100);
            panel2.setBackground(new Color(105, 105, 105));
            panel2.removeAll();
            panel2.setLayout(new GridLayout(2,1));
            panel2.add(textHex);
            panel2.add(hexLabel);
            panel2.revalidate();
            panel2.repaint();
        } 
      }
      //LISTENER FOR OCTAL
      if (e.getSource() == convResult) {
        String input = text1.getText();
    
        if (!input.isEmpty()) {
            double decimalNumber = Double.parseDouble(input);
    
            Octal octalConverter = new Octal();
            octalConverter.num = (int) decimalNumber;

            JLabel textOctal = new JLabel();
            textOctal.setText("The Octal is: ");
            textOctal.setForeground(Color.WHITE);
            textOctal.setFont(font);
            textOctal.setHorizontalAlignment(JLabel.CENTER);
            textOctal.setVerticalAlignment(JLabel.CENTER);

            JLabel octalLabel = new JLabel();
            octalLabel.setText(octalConverter.displayOctal());
            octalLabel.setForeground(Color.WHITE);
            octalLabel.setFont(font);
            octalLabel.setHorizontalAlignment(JLabel.CENTER);
            octalLabel.setVerticalAlignment(JLabel.CENTER);

            if (decimalNumber == 0) {
              octalLabel.setText("0");
            }
    
            panel3.setBounds(40, 450, 300, 100);
            panel3.setBackground(new Color(112, 128, 144));
            panel3.removeAll();
            panel3.setLayout(new GridLayout(2,1));
            panel3.add(textOctal);
            panel3.add(octalLabel);
            panel3.revalidate();
            panel3.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Please input number");
        }
    }
  }
}
