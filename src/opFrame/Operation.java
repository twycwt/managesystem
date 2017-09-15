package opFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.mysql.jdbc.ResultSetMetaData;

public class Operation {
	public Operation() throws Exception {
		// 实例化窗口
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setLayout(new java.awt.BorderLayout());
		frame.setTitle("图书期刊管理系统");
		frame.setLocation(600, 30);
		frame.setSize(700, 945);
		frame.setDefaultCloseOperation(3);

		// 实例化欢迎面板
		JPanel Welcome = new JPanel();
		frame.add(Welcome);

		// 实例化选项面板
		JPanel XXPanel = new JPanel();
		Dimension XXDim = new Dimension(120, 980);
		XXPanel.setPreferredSize(XXDim);
		XXPanel.setLayout(null);
		frame.add(XXPanel, java.awt.BorderLayout.WEST);

		// 实例化查询显示面板
		JPanel CXPanel = new JPanel();
		Dimension PanelDim = new Dimension(470, 980);
		CXPanel.setPreferredSize(PanelDim);
		CXPanel.setLayout(null);
		CXPanel.setBackground(Color.white);

		// 实例化添加显示面板
		JPanel TJPanel = new JPanel();
		TJPanel.setPreferredSize(PanelDim);
		TJPanel.setLayout(null);
		TJPanel.setBackground(Color.white);

		// 实例化删除显示面板
		JPanel SCPanel = new JPanel();
		SCPanel.setPreferredSize(PanelDim);
		SCPanel.setLayout(null);
		SCPanel.setBackground(Color.white);

		// 实例化修改面板
		JPanel XGPanel = new JPanel();
		XGPanel.setPreferredSize(PanelDim);
		XGPanel.setLayout(null);
		XGPanel.setBackground(Color.white);

		// 实例化计算面板
		JPanel JSPanel = new JPanel();
		JSPanel.setPreferredSize(PanelDim);
		JSPanel.setLayout(null);
		JSPanel.setBackground(Color.white);

		// 实例化统计面板
		JPanel TJ1Panel = new JPanel();
		TJ1Panel.setPreferredSize(PanelDim);
		TJ1Panel.setLayout(null);
		TJ1Panel.setBackground(Color.white);

		// 实例化欢迎面板组件欢迎文本框并添加
		JLabel label1 = new JLabel(new ImageIcon("C:\\Users\\lenovo-pc\\Pictures\\电脑壁纸\\图书期刊.jpg"));
		Welcome.add(label1);

		Font font_text = new Font("黑体", Font.PLAIN, 18);
		Font font_button = new Font("宋体", Font.PLAIN, 15);
		Font font_label = new Font("宋体", Font.PLAIN, 17);

		// 实例化选项面板组件：查询、添加、修改、删除、确认按钮并添加
		JButton CX = new JButton("查询");
		JButton TJ = new JButton("添加");
		JButton SC = new JButton("删除");
		JButton XG = new JButton("修改");
		JButton JS = new JButton("计算");
		JButton TJ1 = new JButton("统计");
		CX.setBounds(10, 100, 100, 50);
		CX.setFont(font_button);
		TJ.setBounds(10, 220, 100, 50);
		TJ.setFont(font_button);
		SC.setBounds(10, 340, 100, 50);
		SC.setFont(font_button);
		XG.setBounds(10, 460, 100, 50);
		XG.setFont(font_button);
		JS.setBounds(10, 580, 100, 50);
		JS.setFont(font_button);
		TJ1.setBounds(10, 700, 100, 50);
		TJ1.setFont(font_button);
		XXPanel.add(CX);
		XXPanel.add(TJ);
		XXPanel.add(SC);
		XXPanel.add(XG);
		XXPanel.add(JS);
		XXPanel.add(TJ1);

		// 实例化查询界面组件并添加
		JTextArea CXText = new JTextArea("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
		CXText.setFont(font_text);
		JScrollPane jsp = new JScrollPane(CXText);
		jsp.setBounds(10, 10, 500, 570);

		JTextField InputTextID = new JTextField();
		InputTextID.setBounds(20, 610, 380, 30);
		JButton QR1 = new JButton("按编号查询");
		QR1.setBounds(420, 610, 120, 30);
		QR1.setFont(font_button);
		CXPanel.add(jsp);
		CXPanel.add(InputTextID);
		CXPanel.add(QR1);

		JTextField InputTextName = new JTextField();
		InputTextName.setBounds(20, 650, 380, 30);
		JButton QR2 = new JButton("按名称查询");
		QR2.setBounds(420, 650, 120, 30);
		QR2.setFont(font_button);
		CXPanel.add(InputTextName);
		CXPanel.add(QR2);

		JTextField InputTextCategoryID = new JTextField();
		InputTextCategoryID.setBounds(20, 690, 360, 30);
		JButton QR3 = new JButton("按分类号查询");
		QR3.setBounds(400, 690, 140, 30);
		QR3.setFont(font_button);
		CXPanel.add(InputTextCategoryID);
		CXPanel.add(QR3);

		JTextField InputTextPress = new JTextField();
		InputTextPress.setBounds(20, 730, 340, 30);
		JButton QR4 = new JButton("按出版单位查询");
		QR4.setBounds(380, 730, 160, 30);
		QR4.setFont(font_button);
		CXPanel.add(InputTextPress);
		CXPanel.add(QR4);

		JTextField InputTextISBN = new JTextField();
		InputTextISBN.setBounds(20, 770, 340, 30);
		JButton QR5 = new JButton("按ISBN查询");
		QR5.setBounds(380, 770, 160, 30);
		QR5.setFont(font_button);
		CXPanel.add(InputTextISBN);
		CXPanel.add(QR5);

		JTextField InputTextISSN = new JTextField();
		InputTextISSN.setBounds(20, 810, 340, 30);
		JButton QR6 = new JButton("按ISSN查询");
		QR6.setBounds(380, 810, 160, 30);
		QR6.setFont(font_button);
		CXPanel.add(InputTextISSN);
		CXPanel.add(QR6);

		JButton QRcxall = new JButton("查询");
		QRcxall.setBounds(230, 860, 120, 30);
		QRcxall.setFont(font_button);
		CXPanel.add(QRcxall);

		// 实例化添加面板组件并添加
		JTextArea TJText = new JTextArea("请在下方的文本框输入想要添加图书或期刊的信息" + "\n" + "然后单击添加按钮" + "\n");
		TJText.setFont(font_text);
		TJText.setBounds(10, 10, 500, 80);
		JTextArea TJWCText = new JTextArea();
		TJWCText.setFont(font_text);
		TJWCText.setBounds(10, 750, 500, 80);

		JLabel ID = new JLabel("编号: ");
		JTextField IDtext = new JTextField();
		ID.setFont(font_label);
		ID.setBounds(10, 100, 80, 30);
		IDtext.setBounds(80, 100, 160, 30);

		JLabel name = new JLabel("名称: ");
		name.setFont(font_label);
		name.setBounds(250, 100, 80, 30);
		JTextField nametext = new JTextField();
		nametext.setBounds(300, 100, 180, 30);

		JLabel category = new JLabel("分类号: ");
		category.setFont(font_label);
		category.setBounds(0, 140, 80, 30);
		JTextField categorytext = new JTextField();
		categorytext.setBounds(80, 140, 160, 30);

		JLabel stocknum = new JLabel("库存: ");
		stocknum.setFont(font_label);
		stocknum.setBounds(250, 140, 80, 30);
		JTextField stocknumtext = new JTextField();
		stocknumtext.setBounds(300, 140, 180, 30);

		JLabel pubtime = new JLabel("出版时间: ");
		pubtime.setFont(font_label);
		pubtime.setBounds(0, 180, 120, 30);
		JTextField pubtimetext = new JTextField();
		pubtimetext.setBounds(80, 180, 160, 30);

		JLabel press = new JLabel("出版单位: ");
		press.setFont(font_label);
		press.setBounds(0, 220, 120, 30);
		JTextField presstext = new JTextField();
		presstext.setBounds(80, 220, 160, 30);

		JLabel price = new JLabel("价格: ");
		price.setFont(font_label);
		price.setBounds(250, 180, 60, 30);
		JTextField pricetext = new JTextField();
		pricetext.setBounds(300, 180, 180, 30);

		JTextArea TJText1 = new JTextArea("以上为基本信息" + "\n" + "请在下方输入详细信息添加图书或期刊" + "\n");
		TJText1.setFont(font_text);
		TJText1.setBounds(10, 280, 500, 80);

		JLabel ISBN = new JLabel("ISBN: ");
		ISBN.setFont(font_label);
		ISBN.setBounds(10, 380, 60, 30);
		JTextField ISBNtext = new JTextField();
		ISBNtext.setBounds(60, 380, 180, 30);

		JLabel author = new JLabel("作者: ");
		author.setFont(font_label);
		author.setBounds(250, 380, 60, 30);
		JTextField authortext = new JTextField();
		authortext.setBounds(300, 380, 180, 30);

		JLabel pages = new JLabel("页数: ");
		pages.setFont(font_label);
		pages.setBounds(10, 420, 60, 30);
		JTextField pagestext = new JTextField();
		pagestext.setBounds(60, 420, 180, 30);

		JLabel words = new JLabel("字数: ");
		words.setFont(font_label);
		words.setBounds(250, 420, 60, 30);
		JTextField wordstext = new JTextField();
		wordstext.setBounds(300, 420, 180, 30);

		JLabel ISSN = new JLabel("ISSN: ");
		ISSN.setFont(font_label);
		ISSN.setBounds(10, 550, 60, 30);
		JTextField ISSNtext = new JTextField();
		ISSNtext.setBounds(80, 550, 150, 30);

		JLabel sindex = new JLabel("检索: ");
		sindex.setFont(font_label);
		sindex.setBounds(250, 550, 60, 30);
		JTextField sindextext = new JTextField();
		sindextext.setBounds(330, 550, 150, 30);

		JLabel area = new JLabel("学科领域: ");
		area.setFont(font_label);
		area.setBounds(0, 590, 120, 30);
		JTextField areatext = new JTextField();
		areatext.setBounds(80, 590, 150, 30);

		JLabel factor = new JLabel("影响因子: ");
		factor.setFont(font_label);
		factor.setBounds(250, 590, 120, 30);
		JTextField factortext = new JTextField();
		factortext.setBounds(330, 590, 150, 30);

		JLabel period = new JLabel("出版周期: ");
		period.setFont(font_label);
		period.setBounds(0, 630, 120, 30);
		JTextField periodtext = new JTextField();
		periodtext.setBounds(80, 630, 150, 30);

		JLabel articlesnum = new JLabel("论文数: ");
		articlesnum.setFont(font_button);
		articlesnum.setBounds(250, 630, 120, 30);
		JTextField articlesnumtext = new JTextField();
		articlesnumtext.setBounds(330, 630, 150, 30);

		JButton QR7 = new JButton("添加图书");
		QR7.setFont(font_button);
		QR7.setBounds(200, 480, 120, 30);

		JButton QR8 = new JButton("添加期刊");
		QR8.setFont(font_button);
		QR8.setBounds(200, 700, 120, 30);

		TJPanel.add(TJText);
		TJPanel.add(TJText1);
		TJPanel.add(ID);
		TJPanel.add(IDtext);
		TJPanel.add(name);
		TJPanel.add(nametext);
		TJPanel.add(category);
		TJPanel.add(categorytext);
		TJPanel.add(stocknum);
		TJPanel.add(stocknumtext);
		TJPanel.add(pubtime);
		TJPanel.add(pubtimetext);
		TJPanel.add(press);
		TJPanel.add(presstext);
		TJPanel.add(price);
		TJPanel.add(pricetext);
		TJPanel.add(ISBN);
		TJPanel.add(ISBNtext);
		TJPanel.add(author);
		TJPanel.add(authortext);
		TJPanel.add(pages);
		TJPanel.add(pagestext);
		TJPanel.add(words);
		TJPanel.add(wordstext);
		TJPanel.add(ISSN);
		TJPanel.add(ISSNtext);
		TJPanel.add(sindex);
		TJPanel.add(sindextext);
		TJPanel.add(area);
		TJPanel.add(areatext);
		TJPanel.add(factor);
		TJPanel.add(factortext);
		TJPanel.add(period);
		TJPanel.add(periodtext);
		TJPanel.add(articlesnum);
		TJPanel.add(articlesnumtext);
		TJPanel.add(QR7);
		TJPanel.add(QR8);
		TJPanel.add(TJWCText);

		// 实例化删除面板组件并添加
		JTextArea SCText = new JTextArea("请在下方文本框中输入要删除的图书或期刊编号" + "\n");
		SCText.setBounds(10, 10, 500, 80);
		SCText.setFont(font_text);
		JTextArea HFText = new JTextArea("请在下方文本框中输入要恢复的图书或期刊编号" + "\n");
		HFText.setBounds(10, 620, 500, 60);
		HFText.setFont(font_text);
		JTextArea SCWCText = new JTextArea();
		SCWCText.setFont(font_text);
		SCWCText.setBounds(10, 170, 500, 60);
		JTextArea HFWCText = new JTextArea();
		HFWCText.setFont(font_text);
		HFWCText.setBounds(10, 790, 500, 80);
		JTextArea HFJLText = new JTextArea();
		JScrollPane jspHFJL = new JScrollPane(HFJLText);
		jspHFJL.setBounds(10, 300, 500, 300);
		HFJLText.setFont(font_text);
		JTextField InputTextDel = new JTextField();
		InputTextDel.setBounds(10, 110, 280, 30);
		JTextField InputTextHF = new JTextField();
		InputTextHF.setBounds(10, 710, 280, 30);
		JButton QR9 = new JButton("删除");
		QR9.setFont(font_button);
		QR9.setBounds(300, 110, 80, 30);
		JButton QRHF = new JButton("恢复");
		QRHF.setFont(font_button);
		QRHF.setBounds(300, 710, 80, 30);
		JButton QRCK = new JButton("显示待恢复记录");
		QRCK.setFont(font_button);
		QRCK.setBounds(10, 260, 140, 30);
		SCPanel.add(SCText);
		SCPanel.add(SCWCText);
		SCPanel.add(InputTextDel);
		SCPanel.add(QR9);
		SCPanel.add(HFText);
		SCPanel.add(HFWCText);
		SCPanel.add(jspHFJL);
		SCPanel.add(InputTextHF);
		SCPanel.add(QRHF);
		SCPanel.add(QRCK);

		// 实例化修改面板组件备份文本框并添加
		JTextArea XGText = new JTextArea("请在下方文本框中输入要修改的图书或期刊编号" + "\n");
		XGText.setFont(font_text);
		XGText.setBounds(10, 10, 500, 50);
		JTextField InputTextUpdate = new JTextField();
		InputTextUpdate.setBounds(10, 90, 280, 30);
		JTextArea XGText1 = new JTextArea("请在下方文本框中输入修改后的数据记录" + "\n");
		XGText1.setFont(font_text);
		XGText1.setBounds(10, 180, 500, 50);
		JTextArea XGWCText = new JTextArea();
		XGWCText.setFont(font_text);
		XGWCText.setBounds(10, 450, 500, 100);

		JLabel uoutnum = new JLabel("借出数量：");
		uoutnum.setFont(font_label);
		uoutnum.setBounds(10, 250, 120, 30);
		JTextField InputTextUoutnum = new JTextField();
		InputTextUoutnum.setBounds(100, 250, 180, 30);

		JLabel ustocknum = new JLabel("库存数量：");
		ustocknum.setFont(font_label);
		ustocknum.setBounds(10, 300, 120, 30);
		JTextField InputTextUstocknum = new JTextField();
		InputTextUstocknum.setBounds(100, 300, 180, 30);

		JTextField InputTextUprice = new JTextField();
		InputTextUprice.setBounds(100, 350, 180, 30);
		JLabel uprice = new JLabel("价格：");
		uprice.setFont(font_label);
		uprice.setBounds(10, 350, 120, 30);

		JButton QRxg = new JButton("修改");
		QRxg.setFont(font_button);
		QRxg.setBounds(350, 250, 120, 30);
		JButton QRxg1 = new JButton("修改");
		QRxg1.setFont(font_button);
		QRxg1.setBounds(350, 300, 120, 30);
		JButton QRxg2 = new JButton("修改");
		QRxg2.setFont(font_button);
		QRxg2.setBounds(350, 350, 120, 30);
		XGPanel.add(XGText);
		XGPanel.add(InputTextUpdate);
		XGPanel.add(XGText1);
		XGPanel.add(uoutnum);
		XGPanel.add(InputTextUoutnum);
		XGPanel.add(ustocknum);
		XGPanel.add(InputTextUstocknum);
		XGPanel.add(InputTextUprice);
		XGPanel.add(uprice);
		XGPanel.add(QRxg);
		XGPanel.add(QRxg1);
		XGPanel.add(QRxg2);
		XGPanel.add(XGWCText);
		// 实例化计算面板组件更新文本框并添加
		JTextArea JSText = new JTextArea("请输入待计算每千字价格的图书编号" + "\n\n" + "或" + "\n\n" + "待计算平均单篇论文价格的期刊编号" + "\n");
		JSText.setFont(font_text);
		JSText.setBounds(10, 10, 500, 120);
		JTextArea JSJGText = new JTextArea();
		JSJGText.setFont(font_text);
		JSJGText.setBounds(10, 350, 500, 120);
		JTextArea JSJG1Text = new JTextArea();
		JSJG1Text.setFont(font_text);
		JSJG1Text.setBounds(10, 350, 500, 120);
		JTextField InputTextTprice = new JTextField();
		InputTextTprice.setBounds(10, 150, 180, 30);
		JButton QR10 = new JButton("计算每千字价格");
		QR10.setFont(font_button);
		QR10.setBounds(210, 150, 220, 30);
		JTextField InputTextTAprice = new JTextField();
		InputTextTAprice.setBounds(10, 200, 180, 30);
		JButton QR11 = new JButton("计算平均单篇论文价格");
		QR11.setFont(font_button);
		QR11.setBounds(210, 200, 220, 30);
		JSPanel.add(JSText);
		JSPanel.add(InputTextTprice);
		JSPanel.add(QR10);
		JSPanel.add(InputTextTAprice);
		JSPanel.add(QR11);
		JSPanel.add(JSJGText);
		JSPanel.add(JSJG1Text);

		// 实例化统计面板组件并添加
		JTextArea TJ1Text = new JTextArea("请输入关键字然后点击相应按钮进行统计操作" + "\n");
		TJ1Text.setFont(font_text);
		TJ1Text.setBounds(10, 10, 500, 80);
		JTextArea TJ1JGText = new JTextArea();
		TJ1JGText.setFont(font_text);
		TJ1JGText.setBounds(10, 440, 500, 100);
		JTextField InputTextTJ1 = new JTextField();
		InputTextTJ1.setBounds(10, 100, 120, 30);
		JTextField InputTextTJ2 = new JTextField();
		InputTextTJ2.setBounds(150, 100, 120, 30);
		JTextField InputTextTJ3 = new JTextField();
		InputTextTJ3.setBounds(10, 160, 120, 30);
		JTextField InputTextTJ4 = new JTextField();
		InputTextTJ4.setBounds(150, 160, 120, 30);
		JButton QR15 = new JButton("统计图书总数");
		QR15.setFont(font_button);
		QR15.setBounds(10, 220, 150, 30);
		JButton QR151 = new JButton("统计期刊总数");
		QR151.setFont(font_button);
		QR151.setBounds(260, 220, 150, 30);
		JButton QR12 = new JButton("统计图书总价");
		QR12.setFont(font_button);
		QR12.setBounds(10, 280, 150, 30);
		JButton QR121 = new JButton("统计期刊总价");
		QR121.setFont(font_button);
		QR121.setBounds(260, 280, 150, 30);
		JButton QR13 = new JButton("统计图书平均价");
		QR13.setFont(font_button);
		QR13.setBounds(10, 340, 170, 30);
		JButton QR131 = new JButton("统计期刊平均价");
		QR131.setFont(font_button);
		QR131.setBounds(260, 340, 170, 30);
		JButton QR14 = new JButton("统计该价格区间内图书");
		QR14.setFont(font_button);
		QR14.setBounds(300, 100, 210, 30);
		JButton QR141 = new JButton("统计该价格区间内期刊");
		QR141.setFont(font_button);
		QR141.setBounds(300, 160, 210, 30);

		TJ1Panel.add(TJ1Text);
		TJ1Panel.add(InputTextTJ1);
		TJ1Panel.add(InputTextTJ2);
		TJ1Panel.add(InputTextTJ3);
		TJ1Panel.add(InputTextTJ4);
		TJ1Panel.add(QR14);
		TJ1Panel.add(QR15);
		TJ1Panel.add(QR12);
		TJ1Panel.add(QR13);
		TJ1Panel.add(QR131);
		TJ1Panel.add(QR141);
		TJ1Panel.add(QR121);
		TJ1Panel.add(QR151);
		TJ1Panel.add(TJ1JGText);
		frame.setVisible(true);
		// 设置查询按钮的监听
		CX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(Welcome);
				frame.remove(TJPanel);
				frame.remove(SCPanel);
				frame.remove(XGPanel);
				frame.remove(JSPanel);
				frame.remove(TJ1Panel);
				frame.add(CXPanel, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();
			}
		});
		QR1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中按编号查询图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from basicinfo where id=?");
					ps.setString(1, InputTextID.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from bookinfo where id=?");
						PreparedStatement ps2 = cn.prepareStatement("select * from serialinfo where id=?");
						ps1.setString(1, InputTextID.getText().toString());
						ps2.setString(1, InputTextID.getText().toString());
						ResultSet rs1 = ps1.executeQuery();
						ResultSet rs2 = ps2.executeQuery();
						ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
						ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
						ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
						String str;
						while (rs.next()) {
							for (int a = 1; a <= rsmd.getColumnCount(); a++) {
								str = rs.getString(a);
								CXText.append(rsmd.getColumnName(a) + " : " + str + "\n");
							}
							while (rs1.next()) {
								for (int i = 1; i < rsmd1.getColumnCount(); i++) {
									str = rs1.getString(i);
									CXText.append(rsmd1.getColumnName(i) + " : " + str + "\n");
								}
							}
							while (rs2.next()) {
								for (int i = 1; i < rsmd2.getColumnCount(); i++) {
									str = rs2.getString(i);
									CXText.append(rsmd2.getColumnName(i) + " : " + str + "\n");
								}
							}
						}
						rs1.close();
						rs2.close();
						ps1.close();
						ps1.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "不存在符合该搜索条件的记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextID.setText("");
				}
			}
		});
		QR2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中按名称查询图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from basicinfo where bsname=?");
					ps.setString(1, InputTextName.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from bookinfo where id=?");
						PreparedStatement ps2 = cn.prepareStatement("select * from serialinfo where id=?");
						while (rs.next()) {
							ps1.setString(1, rs.getString("id").toString());
							ps2.setString(1, rs.getString("id").toString());
							ResultSet rs1 = ps1.executeQuery();
							ResultSet rs2 = ps2.executeQuery();
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
							ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
							String str;
							for (int a = 1; a <= rsmd.getColumnCount(); a++) {
								str = rs.getString(a);
								CXText.append(rsmd.getColumnName(a) + " : " + str + "\n");
							}
							System.out.println("搜索成功！");
							while (rs1.next()) {
								for (int i = 1; i < rsmd1.getColumnCount(); i++) {
									str = rs1.getString(i);
									CXText.append(rsmd1.getColumnName(i) + " : " + str + "\n");
								}
							}
							while (rs2.next()) {
								for (int i = 1; i <= rsmd2.getColumnCount(); i++) {
									str = rs2.getString(i);
									CXText.append(rsmd2.getColumnName(i) + " : " + str + "\n");
								}
							}
							CXText.append("\n");
							rs1.close();
							rs2.close();
						}
						ps1.close();
						ps2.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "不存在符合该搜索条件的记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextName.setText("");
				}
			}
		});
		QR3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中按分类号查询图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from basicinfo where category_id=?");
					ps.setString(1, InputTextCategoryID.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from bookinfo where id=?");
						PreparedStatement ps2 = cn.prepareStatement("select * from serialinfo where id=?");
						while (rs.next()) {
							ps1.setString(1, rs.getString("id").toString());
							ps2.setString(1, rs.getString("id").toString());
							ResultSet rs1 = ps1.executeQuery();
							ResultSet rs2 = ps2.executeQuery();
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
							ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
							String str;
							for (int a = 1; a <= rsmd.getColumnCount(); a++) {
								str = rs.getString(a);
								CXText.append(rsmd.getColumnName(a) + " : " + str + "\n");
							}
							System.out.println("搜索成功！");
							while (rs1.next()) {
								for (int i = 1; i < rsmd1.getColumnCount(); i++) {
									str = rs1.getString(i);
									CXText.append(rsmd1.getColumnName(i) + " : " + str + "\n");
								}
							}
							while (rs2.next()) {
								for (int i = 1; i < rsmd2.getColumnCount(); i++) {
									str = rs2.getString(i);
									CXText.append(rsmd2.getColumnName(i) + " : " + str + "\n");
								}
							}
							CXText.append("\n");
							rs1.close();
							rs2.close();
						}
						ps1.close();
						ps2.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "不存在符合该搜索条件的记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextCategoryID.setText("");
				}
			}
		});
		QR4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中按出版单位查询图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from basicinfo where press=?");
					ps.setString(1, InputTextPress.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from bookinfo where id=?");
						PreparedStatement ps2 = cn.prepareStatement("select * from serialinfo where id=?");
						while (rs.next()) {
							ps1.setString(1, rs.getString("id").toString());
							ps2.setString(1, rs.getString("id").toString());
							ResultSet rs1 = ps1.executeQuery();
							ResultSet rs2 = ps2.executeQuery();
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
							ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
							String str;
							for (int a = 1; a <= rsmd.getColumnCount(); a++) {
								str = rs.getString(a);
								CXText.append(rsmd.getColumnName(a) + " : " + str + "\n");
							}
							System.out.println("搜索成功！");
							while (rs1.next()) {
								for (int i = 1; i < rsmd1.getColumnCount(); i++) {
									str = rs1.getString(i);
									CXText.append(rsmd1.getColumnName(i) + " : " + str + "\n");
								}
							}
							while (rs2.next()) {
								for (int i = 1; i < rsmd2.getColumnCount(); i++) {
									str = rs2.getString(i);
									CXText.append(rsmd2.getColumnName(i) + " : " + str + "\n");
								}
							}
							CXText.append("\n");
							rs1.close();
							rs2.close();
						}
						ps1.close();
						ps2.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "不存在符合该搜索条件的记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextPress.setText("");
				}
			}
		});
		QR5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中按ISBN查询图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from bookinfo where ISBN=?");
					ps.setString(1, InputTextISBN.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from basicinfo where id=?");
						while (rs.next()) {
							ps1.setString(1, rs.getString("id").toString());
							ResultSet rs1 = ps1.executeQuery();
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
							String str;
							while (rs1.next()) {
								for (int a = 1; a <= rsmd1.getColumnCount(); a++) {
									str = rs1.getString(a);
									CXText.append(rsmd1.getColumnName(a) + " : " + str + "\n");
								}
							}
							System.out.println("搜索成功！");
							for (int i = 1; i < rsmd.getColumnCount(); i++) {
								str = rs.getString(i);
								CXText.append(rsmd.getColumnName(i) + " : " + str + "\n");
							}
							CXText.append("\n");
							rs1.close();
						}
						ps1.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "不存在符合该搜索条件的记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextISBN.setText("");
				}
			}
		});
		QR6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中按ISSN查询图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from serialinfo where ISSN=?");
					ps.setString(1, InputTextISSN.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from basicinfo where id=?");
						while (rs.next()) {
							ps1.setString(1, rs.getString("id").toString());
							ResultSet rs1 = ps1.executeQuery();
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
							String str;
							while (rs1.next()) {
								for (int a = 1; a <= rsmd1.getColumnCount(); a++) {
									str = rs1.getString(a);
									CXText.append(rsmd1.getColumnName(a) + " : " + str + "\n");
								}
							}
							System.out.println("搜索成功！");
							for (int i = 1; i < rsmd.getColumnCount(); i++) {
								str = rs.getString(i);
								CXText.append(rsmd.getColumnName(i) + " : " + str + "\n");
							}
							CXText.append("\n");
							rs1.close();
						}
						ps1.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "不存在符合该搜索条件的记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextISSN.setText("");
				}
			}
		});
		QRcxall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CXText.setText("请在下方输入文本框中输入想要查询的图书或期刊信息" + "\n" + "若查询所有信息，请直接点击下方查询按钮" + "\n");
				try {
					// 在数据库中查询所有记录
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating CXstatement...");
					PreparedStatement ps = cn.prepareStatement("select * from basicinfo where 1=1");
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						System.out.println("Creating statement1...");
						PreparedStatement ps1 = cn.prepareStatement("select * from bookinfo where id=?");
						PreparedStatement ps2 = cn.prepareStatement("select * from serialinfo where id=?");
						while (rs.next()) {
							ps1.setString(1, rs.getString("id").toString());
							ps2.setString(1, rs.getString("id").toString());
							ResultSet rs1 = ps1.executeQuery();
							ResultSet rs2 = ps2.executeQuery();
							ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
							ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
							ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
							String str;
							for (int a = 1; a <= rsmd.getColumnCount(); a++) {
								str = rs.getString(a);
								CXText.append(rsmd.getColumnName(a) + " : " + str + "\n");
							}
							System.out.println("搜索成功！");
							while (rs1.next()) {
								for (int i = 1; i < rsmd1.getColumnCount(); i++) {
									str = rs1.getString(i);
									CXText.append(rsmd1.getColumnName(i) + " : " + str + "\n");
								}
							}
							while (rs2.next()) {
								for (int i = 1; i < rsmd2.getColumnCount(); i++) {
									str = rs2.getString(i);
									CXText.append(rsmd2.getColumnName(i) + " : " + str + "\n");
								}
							}
							CXText.append("\n");
							rs1.close();
							rs2.close();
						}
						ps1.close();
						ps2.close();
						rs.close();
					} else {
						CXText.append("\n\n" + "数据库中无任何记录！");
						rs.close();
					}
					ps.close();
					cn.close();
				} catch (SQLException se) {// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		// 设置添加按钮的监听
		TJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(Welcome);
				frame.remove(CXPanel);
				frame.remove(SCPanel);
				frame.remove(XGPanel);
				frame.remove(JSPanel);
				frame.remove(TJ1Panel);
				frame.add(TJPanel, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();
			}
		});
		QR7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJText.setText("\n" + "请在下方的文本框输入想要添加图书或期刊的信息" + "\n" + "然后单击添加按钮" + "\n");
				try {
					// 在数据库中添加新的图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("insert into basicinfo values(?,?,?,0,?,?,?,?)");
					ps.setString(1, IDtext.getText().toString());
					ps.setString(2, nametext.getText().toString());
					ps.setString(3, categorytext.getText().toString());
					ps.setString(4, stocknumtext.getText().toString());
					ps.setString(5, pubtimetext.getText().toString());
					ps.setString(6, presstext.getText().toString());
					float p = Float.parseFloat(pricetext.getText().toString());
					ps.setFloat(7, p);
					int rows = ps.executeUpdate();
					System.out.println("Rows impacted : " + rows);
					ps.close();
					System.out.println("Creating statement1...");
					PreparedStatement ps1 = cn.prepareStatement("insert into bookinfo values(?,?,?,?,?,?)");
					ps1.setString(1, ISBNtext.getText().toString());
					ps1.setString(2, authortext.getText().toString());
					ps1.setString(3, pagestext.getText().toString());
					ps1.setString(4, wordstext.getText().toString());
					float tp = Float.parseFloat(pricetext.getText().toString())
							/ Float.parseFloat(wordstext.getText().toString());
					ps1.setFloat(5, tp);
					ps1.setString(6, IDtext.getText().toString());
					int rows1 = ps1.executeUpdate();
					System.out.println("Rows1 impacted : " + rows1);
					ps1.close();
					cn.close();
					TJWCText.setText("添加成功！");

				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
					// InputText3.setText("");
				} finally {
					IDtext.setText("");
					nametext.setText("");
					categorytext.setText("");
					stocknumtext.setText("");
					pubtimetext.setText("");
					presstext.setText("");
					pricetext.setText("");
					ISBNtext.setText("");
					authortext.setText("");
					pagestext.setText("");
					wordstext.setText("");
				}
			}
		});
		QR8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJText.setText("\n" + "请在下方的文本框输入想要添加图书或期刊的信息" + "\n" + "然后单击添加按钮" + "\n");
				try {
					// 在数据库中添加新的图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("insert into basicinfo values(?,?,?,0,?,?,?,?)");
					ps.setString(1, IDtext.getText().toString());
					ps.setString(2, nametext.getText().toString());
					ps.setString(3, categorytext.getText().toString());
					ps.setString(4, stocknumtext.getText().toString());
					ps.setString(5, pubtimetext.getText().toString());
					ps.setString(6, presstext.getText().toString());
					float p = Float.parseFloat(pricetext.getText().toString());
					ps.setFloat(7, p);
					int rows = ps.executeUpdate();
					System.out.println("Rows impacted : " + rows);
					ps.close();
					System.out.println("Creating statement2...");
					PreparedStatement ps1 = cn.prepareStatement("insert into serialinfo values(?,?,?,?,?,?,?,?)");
					ps1.setString(1, ISSNtext.getText().toString());
					ps1.setString(2, sindextext.getText().toString());
					ps1.setString(3, areatext.getText().toString());
					ps1.setString(4, factortext.getText().toString());
					ps1.setString(5, periodtext.getText().toString());
					ps1.setString(6, articlesnumtext.getText().toString());
					float ap = Float.parseFloat(pricetext.getText().toString())
							/ Float.parseFloat(articlesnumtext.getText().toString());
					ps1.setFloat(7, ap);
					ps1.setString(8, IDtext.getText().toString());
					int rows1 = ps1.executeUpdate();
					System.out.println("Rows1 impacted : " + rows1);
					ps1.close();
					cn.close();
					TJWCText.setText("添加成功！");
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
					// InputText3.setText("");
				} finally {
					IDtext.setText("");
					nametext.setText("");
					categorytext.setText("");
					stocknumtext.setText("");
					pubtimetext.setText("");
					presstext.setText("");
					pricetext.setText("");
					ISSNtext.setText("");
					sindextext.setText("");
					areatext.setText("");
					factortext.setText("");
					periodtext.setText("");
					articlesnumtext.setText("");
				}
			}
		});
		// 实例化删除按钮的监听
		SC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HFWCText.setText("");
				frame.remove(Welcome);
				frame.remove(CXPanel);
				frame.remove(TJPanel);
				frame.remove(XGPanel);
				frame.remove(JSPanel);
				frame.remove(TJ1Panel);
				frame.add(SCPanel, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();
			}
		});
		QR9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SCText.setText("请在下方文本框中输入要删除的图书或期刊编号" + "\n");
				try {
					// 在数据库中删除图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement psbfb = cn.prepareStatement("select * from bookinfo where id=?");
					PreparedStatement psbfs = cn.prepareStatement("select * from serialinfo where id=?");
					psbfb.setString(1, InputTextDel.getText().toString());
					psbfs.setString(1, InputTextDel.getText().toString());
					PreparedStatement psbf = cn.prepareStatement("select * from basicinfo where id=?");
					psbf.setString(1, InputTextDel.getText().toString());
					ResultSet rsbf = psbf.executeQuery();
					ResultSet rsbfb = psbfb.executeQuery();
					ResultSet rsbfs = psbfs.executeQuery();
					if (rsbf.next()) {
						rsbf.previous();
						while (rsbf.next()) {
							String did = rsbf.getString("id");
							String dbsname = rsbf.getString("bsname");
							String dcategory_id = rsbf.getString("category_id");
							String doutnum = rsbf.getString("outnum");
							String dstocknum = rsbf.getString("stocknum");
							String dpub_time = rsbf.getString("pub_time");
							String dpress = rsbf.getString("press");
							String dprice = rsbf.getString("price");
							System.out.println("Creating bfstatement...");
							PreparedStatement psbf1 = cn
									.prepareStatement("insert into deletedbasicinfo values(?,?,?,?,?,?,?,?)");
							psbf1.setString(1, did);
							psbf1.setString(2, dbsname);
							psbf1.setString(3, dcategory_id);
							psbf1.setString(4, doutnum);
							psbf1.setString(5, dstocknum);
							psbf1.setString(6, dpub_time);
							psbf1.setString(7, dpress);
							psbf1.setString(8, dprice);
							int rowsbf1 = psbf1.executeUpdate();
							System.out.println("Rows impacted : " + rowsbf1);
							psbf1.close();
						}
						if (rsbfb.next()) {
							rsbfb.previous();
							while (rsbfb.next()) {
								String dISBN = rsbfb.getString("ISBN");
								String dauthor = rsbfb.getString("author");
								String dpages = rsbfb.getString("pages");
								String dwords = rsbfb.getString("words");
								String dtprice = rsbfb.getString("tprice");
								String did = rsbfb.getString("id");
								System.out.println("Creating bfbstatement...");
								PreparedStatement psbfb1 = cn
										.prepareStatement("insert into deletedbookinfo values(?,?,?,?,?,?)");
								psbfb1.setString(1, dISBN);
								psbfb1.setString(2, dauthor);
								psbfb1.setString(3, dpages);
								psbfb1.setString(4, dwords);
								psbfb1.setString(5, dtprice);
								psbfb1.setString(6, did);
								int rowsbfb1 = psbfb1.executeUpdate();
								System.out.println("Rows impacted : " + rowsbfb1);
								PreparedStatement ps = cn.prepareStatement("delete from bookinfo where id=?");
								ps.setString(1, InputTextDel.getText().toString());
								int rows = ps.executeUpdate();
								System.out.println("Rows impacted : " + rows);
								ps.close();
								psbfb1.close();
							}
							rsbfb.close();
							psbfb.close();

						} else {
							while (rsbfs.next()) {
								String dISSN = rsbfs.getString("ISSN");
								String ds_index = rsbfs.getString("s_index");
								String dareas = rsbfs.getString("areas");
								String difactor = rsbfs.getString("ifactor");
								String dpub_period = rsbfs.getString("pub_period");
								String darticles_num = rsbfs.getString("articles_num");
								String daverage_price = rsbfs.getString("average_price");
								String did = rsbfs.getString("id");
								System.out.println("Creating bfsstatement...");
								PreparedStatement psbfs1 = cn
										.prepareStatement("insert into deletedserialinfo values(?,?,?,?,?,?,?,?)");
								psbfs1.setString(1, dISSN);
								psbfs1.setString(2, ds_index);
								psbfs1.setString(3, dareas);
								psbfs1.setString(4, difactor);
								psbfs1.setString(5, dpub_period);
								psbfs1.setString(6, darticles_num);
								psbfs1.setString(7, daverage_price);
								psbfs1.setString(8, did);
								int rowsbfs1 = psbfs1.executeUpdate();
								System.out.println("Rows impacted : " + rowsbfs1);
								PreparedStatement ps1 = cn.prepareStatement("delete from serialinfo where id=?");
								ps1.setString(1, InputTextDel.getText().toString());
								int rows1 = ps1.executeUpdate();
								System.out.println("Rows impacted : " + rows1);
								ps1.close();
								psbfs1.close();
							}
							rsbfs.close();
							psbfs.close();
						}
						System.out.println("Creating statement2...");
						PreparedStatement ps2 = cn.prepareStatement("delete from basicinfo where id=?");
						ps2.setString(1, InputTextDel.getText().toString());
						int rows2 = ps2.executeUpdate();
						System.out.println("Rows impacted : " + rows2);
						ps2.close();
						SCWCText.setText("删除成功！");
					} else
						SCWCText.setText("删除失败！不存在此编号的图书或期刊！");
					rsbf.close();
					psbf.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextDel.setText("");
				}
			}
		});
		// 实例化查看可恢复记录按钮的监听
		QRCK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HFText.setText("请在下方文本框中输入要恢复的图书或期刊编号" + "\n");
				HFJLText.setText("");
				try {
					// 在数据库中查看待恢复记录
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("select * from deletedbasicinfo");
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							String did = rs.getString("did");
							String dbsname = rs.getString("dbsname");
							String dpub_time = rs.getString("dpub_time");
							String dpress = rs.getString("dpress");
							HFJLText.append("id: " + did + "\n" + "name: " + dbsname + "\n" + "pub_time: " + dpub_time
									+ "\n" + "press:" + dpress + "\n");
						}
						HFJLText.append("以上为可恢复记录");
					} else
						HFJLText.append("\n\n\n" + "不存在可恢复记录！");
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		// 实例化恢复按钮的监听
		QRHF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HFText.setText("请在下方文本框中输入要恢复的图书或期刊编号" + "\n");
				HFWCText.setText("");
				try {
					// 在数据库中恢复记录
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select * from deletedbasicinfo where did=? and ? not in(select id from basicinfo)");
					ps.setString(1, InputTextHF.getText().toString());
					ps.setString(2, InputTextHF.getText().toString());
					PreparedStatement ps1 = cn.prepareStatement("select * from deletedbookinfo where did=?");
					ps1.setString(1, InputTextHF.getText().toString());
					PreparedStatement ps2 = cn.prepareStatement("select * from deletedserialinfo where did=?");
					ps2.setString(1, InputTextHF.getText().toString());

					ResultSet rs = ps.executeQuery();
					System.out.println("执行1");
					ResultSet rs1 = ps1.executeQuery();
					System.out.println("执行2");
					ResultSet rs2 = ps2.executeQuery();
					System.out.println("执行3");
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							PreparedStatement pshfb = cn
									.prepareStatement("insert into basicinfo values(?,?,?,?,?,?,?,?)");
							pshfb.setString(1, rs.getString("did"));
							pshfb.setString(2, rs.getString("dbsname"));
							pshfb.setString(3, rs.getString("dcategory_id"));
							pshfb.setString(4, rs.getString("doutnum"));
							pshfb.setString(5, rs.getString("dstocknum"));
							pshfb.setString(6, rs.getString("dpub_time"));
							pshfb.setString(7, rs.getString("dpress"));
							pshfb.setString(8, rs.getString("dprice"));
							int rows = pshfb.executeUpdate();
							System.out.println("Rows impacted: " + rows);
							if (rs1.next()) {
								rs1.previous();
								while (rs1.next()) {
									PreparedStatement pshfbb = cn
											.prepareStatement("insert into bookinfo values(?,?,?,?,?,?)");
									pshfbb.setString(1, rs1.getString("dISBN"));
									pshfbb.setString(2, rs1.getString("dauthor"));
									pshfbb.setString(3, rs1.getString("dpages"));
									pshfbb.setString(4, rs1.getString("dwords"));
									pshfbb.setString(5, rs1.getString("dtprice"));
									pshfbb.setString(6, rs1.getString("did"));
									int rows1 = pshfbb.executeUpdate();
									System.out.println("Rows impacted: " + rows1);
									pshfbb.close();
									PreparedStatement pshfdb = cn
											.prepareStatement("delete from deletedbookinfo where dISBN=?");
									pshfdb.setString(1, rs1.getString("dISBN"));
									int rowsd1 = pshfdb.executeUpdate();
									System.out.println("Rows impacted: " + rowsd1);
									pshfdb.close();
								}
							} else {
								while (rs2.next()) {
									PreparedStatement pshfbs = cn
											.prepareStatement("insert into serialinfo values(?,?,?,?,?,?,?,?)");
									pshfbs.setString(1, rs2.getString("dISSN"));
									pshfbs.setString(2, rs2.getString("ds_index"));
									pshfbs.setString(3, rs2.getString("dareas"));
									pshfbs.setString(4, rs2.getString("difactor"));
									pshfbs.setString(5, rs2.getString("dpub_period"));
									pshfbs.setString(6, rs2.getString("darticles_num"));
									pshfbs.setString(7, rs2.getString("daverage_price"));
									pshfbs.setString(8, rs2.getString("did"));
									int rows2 = pshfbs.executeUpdate();
									System.out.println("Rows impacted: " + rows2);
									pshfbs.close();
									PreparedStatement pshfds = cn
											.prepareStatement("delete from deletedserialinfo where dISSN=?");
									pshfds.setString(1, rs2.getString("dISSN"));
									int rowsd2 = pshfds.executeUpdate();
									System.out.println("Rows impacted: " + rowsd2);
									pshfds.close();
								}
							}
							pshfb.close();
							PreparedStatement pshfd = cn.prepareStatement("delete from deletedbasicinfo where did=?");
							pshfd.setString(1, rs.getString("did"));
							int rowsd = pshfd.executeUpdate();
							System.out.println("Rows impacted: " + rowsd);
							pshfd.close();
						}

						HFWCText.setText("恢复成功！");
					} else
						HFWCText.setText("恢复失败！");
					rs.close();
					rs1.close();
					rs2.close();
					ps.close();
					ps1.close();
					ps2.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextHF.setText("");
				}
			}
		});
		// 设置修改按钮的监听
		XG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(Welcome);
				frame.remove(CXPanel);
				frame.remove(TJPanel);
				frame.remove(SCPanel);
				frame.remove(JSPanel);
				frame.remove(TJ1Panel);
				frame.add(XGPanel, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();
			}
		});
		// 实例化修改按钮的监听
		QRxg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XGText.setText("请在下方文本框中输入要修改的图书或期刊编号" + "\n");
				XGText1.setText("请在下方文本框中输入修改后的数据记录" + "\n");
				XGWCText.setText("");
				try {
					// 在数据库中修改图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("update basicinfo set outnum=? where id=? and ?>=0");
					ps.setString(1, InputTextUoutnum.getText().toString());
					ps.setString(2, InputTextUpdate.getText().toString());
					ps.setString(3, InputTextUoutnum.getText().toString());
					int rows = ps.executeUpdate();
					System.out.println("Rows impacted : " + rows);
					ps.close();

					cn.close();
					if (rows != 0)
						XGWCText.setText("修改成功！");
					else
						XGWCText.setText("修改失败！" + "\n" + "可能的失败原因：" + "\n" + "不存在此编号的图书期刊或输入的借出量不合理！");
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextUoutnum.setText("");
				}
			}
		});
		QRxg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XGText.setText("请在下方文本框中输入要修改的图书或期刊编号" + "\n");
				XGText1.setText("请在下方文本框中输入修改后的数据记录" + "\n");
				XGWCText.setText("");
				try {
					// 在数据库中修改图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("update basicinfo set stocknum=? where id=? and ?>=0");
					ps.setString(1, InputTextUstocknum.getText().toString());
					ps.setString(2, InputTextUpdate.getText().toString());
					ps.setString(3, InputTextUstocknum.getText().toString());
					int rows = ps.executeUpdate();
					System.out.println("Rows impacted : " + rows);
					ps.close();
					cn.close();
					if (rows != 0)
						XGWCText.setText("修改成功！");
					else
						XGWCText.setText("修改失败！" + "\n" + "可能的失败原因：" + "\n" + "不存在此编号的图书期刊或输入的库存量不合理！");
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextUstocknum.setText("");
				}
			}
		});
		QRxg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XGText.setText("请在下方文本框中输入要修改的图书或期刊编号" + "\n");
				XGText1.setText("请在下方文本框中输入修改后的数据记录" + "\n");
				XGWCText.setText("");
				try {
					// 在数据库中修改图书或期刊
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("update basicinfo set price=? where id=? and ?>0");
					ps.setFloat(1, Float.parseFloat(InputTextUprice.getText().toString()));
					ps.setString(2, InputTextUpdate.getText().toString());
					ps.setFloat(3, Float.parseFloat(InputTextUprice.getText().toString()));
					int rows = ps.executeUpdate();
					System.out.println("Rows impacted : " + rows);
					ps.close();
					cn.close();
					if (rows != 0)
						XGWCText.setText("修改成功！");
					else
						XGWCText.setText("修改失败！" + "\n" + "可能的失败原因：" + "\n" + "不存在此编号的图书期刊或输入的价格不合理！");
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextUprice.setText("");
				}
			}
		});
		// 设置计算按钮的监听
		JS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(Welcome);
				frame.remove(CXPanel);
				frame.remove(TJPanel);
				frame.remove(SCPanel);
				frame.remove(XGPanel);
				frame.remove(TJ1Panel);
				frame.add(JSPanel, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();

			}
		});
		QR10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSText.setText("请输入待计算每千字价格的图书编号" + "\n\n" + "或" + "\n\n" + "待计算平均单篇论文价格的期刊编号" + "\n");
				JSJGText.setText("");
				try {
					// 在数据库中计算某书本每千字价格
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("select tprice from bookinfo where id=?");
					ps.setString(1, InputTextTprice.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							String str = rs.getString("tprice");
							JSJGText.append("该书每千字价格价格为：" + str);
						}
					} else
						JSJGText.append("该图书不存在！计算失败！");
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextTprice.setText("");
				}
			}
		});
		QR11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSText.setText("请输入待计算每千字价格的图书编号" + "\n\n" + "或" + "\n\n" + "待计算平均单篇论文价格的期刊编号" + "\n");
				JSJG1Text.setText("");
				try {
					// 在数据库中计算某书本每千字价格
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement("select average_price from serialinfo where id=?");
					ps.setString(1, InputTextTAprice.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							String str = rs.getString("average_price");
							JSJG1Text.append("该期刊平均每篇论文价格为：" + str);
						}
					} else
						JSJG1Text.append("该期刊不存在！计算失败！");
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextTAprice.setText("");
				}
			}
		});
		// 设置统计按钮的监听
		TJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(Welcome);
				frame.remove(CXPanel);
				frame.remove(TJPanel);
				frame.remove(SCPanel);
				frame.remove(XGPanel);
				frame.remove(JSPanel);
				frame.add(TJ1Panel, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();

			}
		});
		QR14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select id,bsname,price from basicinfo where price>=? and price<=? and id in(select id from bookinfo);");
					ps.setString(1, InputTextTJ1.getText().toString());
					ps.setString(2, InputTextTJ2.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							String str1 = rs.getString("id");
							String str2 = rs.getString("bsname");
							String str3 = rs.getString("price");
							TJ1JGText.append("编号：" + str1 + "  名称：" + str2 + " 价格：" + str3 + "\n");
						}
					} else
						TJ1JGText.append("不存在符合该条件的记录！");
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextTJ1.setText("");
					InputTextTJ2.setText("");
				}
			}
		});
		QR141.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select id,bsname,price from basicinfo where price>=? and price<=? and id in(select id from serialinfo);");
					ps.setString(1, InputTextTJ3.getText().toString());
					ps.setString(2, InputTextTJ4.getText().toString());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							String str1 = rs.getString("id");
							String str2 = rs.getString("bsname");
							String str3 = rs.getString("price");
							TJ1JGText.append("编号：" + str1 + "  名称：" + str2 + " 价格：" + str3 + "\n");
						}
					} else
						TJ1JGText.append("不存在符合该条件的记录！");
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					InputTextTJ3.setText("");
					InputTextTJ4.setText("");
				}
			}
		});
		QR15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select outnum,stocknum from basicinfo where id in(select id from bookinfo);");
					ResultSet rs = ps.executeQuery();
					int totalnum = 0;
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							int outnum = Integer.parseInt(rs.getString("outnum"));
							int stocknum = Integer.parseInt(rs.getString("stocknum"));
							totalnum = totalnum + outnum + stocknum;
						}
						TJ1JGText.setText("当前数据库中图书总数为：" + totalnum);
					} else {
						TJ1JGText.setText("当前数据库中无图书！");
					}
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		QR151.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select outnum,stocknum from basicinfo where id in(select id from serialinfo);");
					ResultSet rs = ps.executeQuery();
					int totalnum = 0;
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							int outnum = Integer.parseInt(rs.getString("outnum"));
							int stocknum = Integer.parseInt(rs.getString("stocknum"));
							totalnum = totalnum + outnum + stocknum;
						}
						TJ1JGText.setText("当前数据库中期刊总数为：" + totalnum);
					} else {
						TJ1JGText.setText("当前数据库中无期刊！");
					}
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		QR12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select outnum,stocknum,price from basicinfo where id in(select id from bookinfo);");
					ResultSet rs = ps.executeQuery();
					float sum = 0;
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							int outnum = Integer.parseInt(rs.getString("outnum"));
							int stocknum = Integer.parseInt(rs.getString("stocknum"));
							float price = rs.getFloat("price");
							sum = sum + (outnum + stocknum) * price;
						}
						TJ1JGText.setText("当前数据库中图书总价为：" + sum);
					} else {
						TJ1JGText.setText("当前数据库中无图书！总价为0");
					}
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		QR121.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select outnum,stocknum,price from basicinfo where id in(select id from serialinfo);");
					ResultSet rs = ps.executeQuery();
					float sum = 0;
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							int outnum = Integer.parseInt(rs.getString("outnum"));
							int stocknum = Integer.parseInt(rs.getString("stocknum"));
							float price = rs.getFloat("price");
							sum = sum + (outnum + stocknum) * price;
						}
						TJ1JGText.setText("当前数据库中期刊总价为：" + sum);
					} else {
						TJ1JGText.setText("当前数据库中无期刊！总价为0");
					}
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		QR13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select outnum,stocknum,price from basicinfo where id in(select id from bookinfo);");
					ResultSet rs = ps.executeQuery();
					float sum = 0;
					int totalnum = 0;
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							int outnum = Integer.parseInt(rs.getString("outnum"));
							int stocknum = Integer.parseInt(rs.getString("stocknum"));
							float price = rs.getFloat("price");
							sum = sum + (outnum + stocknum) * price;
							totalnum = totalnum + outnum + stocknum;
						}
						float avgprice = sum / totalnum;
						TJ1JGText.setText("当前数据库中图书平均价为：" + avgprice);
					} else {
						TJ1JGText.setText("当前数据库中无图书！平均价为0");
					}
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
		QR131.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ1Text.setText("请输入关键字然后点击相应按钮进行统计操作" + "\n");
				TJ1JGText.setText("");
				try {
					// 在数据库中根据关键字对记录进行统计
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/managesystem?characterEncoding=utf8&useSSL=true", "root",
							"twy97620");
					System.out.println("Connecting to database...");
					System.out.println("Creating statement...");
					PreparedStatement ps = cn.prepareStatement(
							"select outnum,stocknum,price from basicinfo where id in(select id from serialinfo);");
					ResultSet rs = ps.executeQuery();
					float sum = 0;
					int totalnum = 0;
					if (rs.next()) {
						rs.previous();
						while (rs.next()) {
							int outnum = Integer.parseInt(rs.getString("outnum"));
							int stocknum = Integer.parseInt(rs.getString("stocknum"));
							float price = rs.getFloat("price");
							sum = sum + (outnum + stocknum) * price;
							totalnum = totalnum + outnum + stocknum;
						}
						float avgprice = sum / totalnum;
						TJ1JGText.setText("当前数据库中期刊平均价为：" + avgprice);
					} else {
						TJ1JGText.setText("当前数据库中无期刊！平均价为0");
					}
					rs.close();
					ps.close();
					cn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
				}
			}
		});
	}// Operation()结束

}
