package ready;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class gui_one extends JFrame {
	JLabel nameJLabel = new JLabel("用户名");
	JLabel passwordJLabel = new JLabel("密码");
	JButton studentButton = new JButton("学生端");
	JButton teacherButton = new JButton("管理端");
	JButton sign_inButton = new JButton("学生注册");
	JTextField nameField = new JTextField(20);
	JPasswordField passwordField = new JPasswordField(20);
	JButton loginButton = new JButton("登录");
	JButton backButton = new JButton("返回");

	public gui_one(String title) {
		setLayout(new FlowLayout());
		add(studentButton);
		add(teacherButton);
		add(sign_inButton);
		teacherButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame1 = new JFrame("请登录");
				frame1.setLocation(200, 50);
				frame1.setSize(250, 200);
				frame1.setLayout(new FlowLayout());
				frame1.setVisible(true);
				frame1.add(nameJLabel);
				frame1.add(nameField);
				frame1.add(passwordJLabel);
				frame1.add(passwordField);
				frame1.add(loginButton);
				frame1.add(backButton);
				loginButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						String n = nameField.getText();
						String p = new String(passwordField.getPassword());

						StringBuffer mBuffer = new StringBuffer();

						mBuffer.append(n);
						mBuffer.append(" ");
						mBuffer.append(p);

						File f = new File("c:\\Users\\曹力\\Desktop\\manage.txt");
						nameField.setText("");
						passwordField.setText("");
						FileReader fre;
						try {
							fre = new FileReader(f);

							BufferedReader bre = new BufferedReader(fre);

							String str = "";

							while ((str = bre.readLine()) != null) // ●判断最后一行不存在，为空
							{
								JFrame frame2 = new JFrame("2");
								JFrame frame3 = new JFrame("3");
								String[] strs = str.split(",");

								for (int i = 0; i < strs.length; i++) {
									if (mBuffer.toString().equals(strs[i])) {
										// System.out.println("1");
										// System.out.println(strs[i]);
										frame3.setSize(500, 700);
										frame3.setLocation(500, 100);
										frame3.setVisible(true);
										String magString = new String("管理员：" + n);

										JPanel panel1 = new JPanel();
										JPanel panel2 = new JPanel();
										JPanel panel3 = new JPanel();
										frame3.setLayout(new BorderLayout());
										frame3.add(panel1, BorderLayout.NORTH);
										frame3.add(panel2, BorderLayout.CENTER);
										frame3.add(panel3, BorderLayout.SOUTH);
										JLabel label1 = new JLabel(magString, JLabel.CENTER);

										JButton button1 = new JButton("创建课程");
										JButton button2 = new JButton("删除课程");
										JButton button3 = new JButton(" 退出  ");
										JPanel panel11 = new JPanel();
										JLabel l1 = new JLabel("编号", JLabel.CENTER);
										JLabel l2 = new JLabel("课程", JLabel.CENTER);
										JLabel l3 = new JLabel("地点", JLabel.CENTER);
										JLabel l4 = new JLabel("时间", JLabel.CENTER);
										JLabel l5 = new JLabel("教师", JLabel.CENTER);
										panel1.setLayout(new BorderLayout());
										panel11.setLayout(new GridLayout(1, 5));
										panel1.add(label1, BorderLayout.NORTH);
										panel1.add(panel11, BorderLayout.SOUTH);
										panel11.add(l1);
										panel11.add(l2);
										panel11.add(l3);
										panel11.add(l4);
										panel11.add(l5);

										panel3.add(button1);
										panel3.add(button2);
										panel3.add(button3);

										File c = new File("c:\\Users\\曹力\\Desktop\\course.txt");

										FileReader cou = new FileReader(c);

										BufferedReader bou = new BufferedReader(cou);

										String cString = "";
										cString = bou.readLine();

										String[] course = cString.split(",");
										panel2.setLayout(new GridLayout(course.length, 5));
										for (int j = 0; j < course.length; j++) {
											String[] courses = course[j].split(" ");
											for (int k = 0; k < 5; k++) {
												JLabel aJLabel = new JLabel(courses[k], JLabel.CENTER);
												panel2.add(aJLabel);
											}
										}
										cou.close();
										bou.close();

										button1.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub

												JFrame frame4 = new JFrame("4");
												JPanel panel41 = new JPanel();
												JPanel panel42 = new JPanel();
												JButton button41 = new JButton("创建");
												JButton button42 = new JButton("清空");
												JLabel label41 = new JLabel("编号", JLabel.CENTER);
												JLabel label42 = new JLabel("课程", JLabel.CENTER);
												JLabel label43 = new JLabel("地点", JLabel.CENTER);
												JLabel label44 = new JLabel("时间", JLabel.CENTER);
												JLabel label45 = new JLabel("教师", JLabel.CENTER);
												JTextField textField41 = new JTextField(10);
												JTextField textField42 = new JTextField(10);
												JTextField textField43 = new JTextField(10);
												JTextField textField44 = new JTextField(10);
												JTextField textField45 = new JTextField(10);

												frame4.setSize(500, 700);
												frame4.setLocation(500, 100);
												frame4.setVisible(true);
												frame4.setLayout(new BorderLayout());
												frame4.add(panel41, BorderLayout.CENTER);
												frame4.add(panel42, BorderLayout.SOUTH);
												panel41.setLayout(new GridLayout(5, 2));
												panel41.add(label41);
												panel41.add(textField41);
												panel41.add(label42);
												panel41.add(textField42);
												panel41.add(label43);
												panel41.add(textField43);
												panel41.add(label44);
												panel41.add(textField44);
												panel41.add(label45);
												panel41.add(textField45);
												panel42.add(button41);
												panel42.add(button42);
												StringBuffer information = new StringBuffer();
												button41.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														String numberString = textField41.getText();
														String courseString = textField42.getText();
														String placeString = textField43.getText();
														String timeString = textField44.getText();
														String teacherString = textField45.getText();

														information.append(numberString + " ");
														information.append(courseString + " ");
														information.append(placeString + " ");
														information.append(timeString + " ");
														information.append(teacherString + ",");
														String inforString = new String(information);
														System.out.println(inforString);
														try {
															// 打开一个随机访问文件流，按读写方式
															RandomAccessFile randomFile = new RandomAccessFile(
																	"c:\\Users\\曹力\\Desktop\\course.txt", "rw");
															// 文件长度，字节数
															long fileLength = randomFile.length();
															// 将写文件指针移到文件尾。
															randomFile.seek(fileLength);
															randomFile.writeBytes(inforString);
															randomFile.close();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														frame4.setVisible(false);
														frame3.setVisible(false);
														frame3.remove(panel2);
														File c = new File("c:\\Users\\曹力\\Desktop\\course.txt");
														JPanel panel2i = new JPanel();
														panel2i.removeAll();

														FileReader cou;
														try {
															cou = new FileReader(c);
															BufferedReader bou = new BufferedReader(cou);

															String cString = "";
															cString = bou.readLine();

															String[] course = cString.split(",");

															panel2i.setLayout(new GridLayout(course.length, 5));
															for (int j = 0; j < course.length; j++) {
																String[] courses = course[j].split(" ");
																for (int k = 0; k < 5; k++) {
																	JLabel aJLabel = new JLabel(courses[k],
																			JLabel.CENTER);
																	panel2i.add(aJLabel);
																}
															}
															frame3.add(panel2i, BorderLayout.CENTER);
															cou.close();
															bou.close();
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}

														frame3.setVisible(true);
														panel2i.repaint();
														frame3.add(panel2i);
													}
												});
											}
										});
										button2.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												JFrame frame5 = new JFrame("5");
												frame5.setSize(500, 700);
												frame5.setLocation(500, 100);
												frame5.setVisible(true);
												frame5.setLayout(new BorderLayout());
												JPanel panel21 = new JPanel();
												JPanel panel22 = new JPanel();
												JPanel panel23 = new JPanel();
												JLabel label21 = new JLabel();
												frame5.add(panel21, BorderLayout.NORTH);
												frame5.add(panel22, BorderLayout.CENTER);
												frame5.add(panel23, BorderLayout.SOUTH);
												panel21.setLayout(new GridLayout(1, 6));
												panel21.add(label21);
												panel21.add(l1);
												panel21.add(l2);
												panel21.add(l3);
												panel21.add(l4);
												panel21.add(l5);

												File c = new File("c:\\Users\\曹力\\Desktop\\course.txt");

												FileReader cou;
												try {
													cou = new FileReader(c);
													BufferedReader bou = new BufferedReader(cou);

													String cString = "";
													cString = bou.readLine();

													String[] course = cString.split(",");
													panel22.setLayout(new GridLayout(course.length, 6));
													ButtonGroup btnGroup = new ButtonGroup();

													for (int j = 0; j < course.length; j++) {
														String aString = new String(String.valueOf(j + 1));
														JRadioButton radioButton = new JRadioButton(aString);
														panel22.add(radioButton);
														btnGroup.add(radioButton);
														String[] courses = course[j].split(" ");
														for (int k = 0; k < 5; k++) {
															JLabel aJLabel = new JLabel(courses[k], JLabel.CENTER);
															panel22.add(aJLabel);
														}
													}
													cou.close();
													bou.close();
												} catch (Exception e2) {
													// TODO Auto-generated catch block
													e2.printStackTrace();
												}

												JButton button21 = new JButton("确定");
												JButton button22 = new JButton("返回");
												panel23.add(button21);
												panel23.add(button22);
												button21.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														String jta2 = new String();
														Component[] com = panel22.getComponents();

														if (null != com) {

															for (int i = 0; i < com.length; i++) {

																if (com[i] instanceof JRadioButton) {
																	JRadioButton jrb = (JRadioButton) com[i];
																	if (jrb.isSelected()) {
																		jta2 = jrb.getText();

																	}
																}
															}
														}
														System.out.println(jta2);
														File c = new File("c:\\Users\\曹力\\Desktop\\course.txt");

														FileReader cou;
														StringBuffer courseBuffer = new StringBuffer();
														try {
															cou = new FileReader(c);
															BufferedReader bou = new BufferedReader(cou);

															String crString = "";
															crString = bou.readLine();

															String[] course = crString.split(",");
															cou.close();
															bou.close();
															course[Integer.valueOf(jta2) - 1] = "";

															for (int i = 0; i < course.length; i++) {
																courseBuffer.append(course[i]);

																if (course[i] == "") {
																	continue;
																} else {
																	courseBuffer.append(",");
																}

															}
															System.out.println(courseBuffer.toString());
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														FileWriter writer;
														try {
															writer = new FileWriter(c);
															writer.write(courseBuffer.toString());
															writer.flush();
															writer.close();

														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();

														}

														frame5.setVisible(false);
														frame3.setVisible(false);

														frame3.remove(panel2);
														File c1 = new File("c:\\Users\\曹力\\Desktop\\course.txt");

														FileReader cou1;
														try {
															cou1 = new FileReader(c1);
															BufferedReader bou = new BufferedReader(cou1);

															String cString = "";
															cString = bou.readLine();

															String[] course = cString.split(",");
															JPanel panel2 = new JPanel();
															panel2.setLayout(new GridLayout(course.length, 5));
															for (int j = 0; j < course.length; j++) {
																String[] courses = course[j].split(" ");
																for (int k = 0; k < 5; k++) {
																	JLabel aJLabel = new JLabel(courses[k],
																			JLabel.CENTER);
																	panel2.add(aJLabel);
																}
															}
															frame3.add(panel2, BorderLayout.CENTER);
															cou1.close();
															bou.close();
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}

														frame3.setVisible(true);

													}

												});

												button22.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														frame5.setVisible(false);
													}
												});
											}
										});
										button3.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												frame1.setVisible(false);
												frame3.setVisible(false);
											}
										});

										break;
									} else {
										if (i == strs.length - 1) {
											JLabel label2 = new JLabel("请输入正确用户名、密码");
											frame2.setSize(200, 100);
											frame2.add(label2);
											frame2.setVisible(true);
										} else {
											continue;
										}

									}
								}
							}
							bre.close();
							fre.close();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				backButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame1.setVisible(false);
					}
				});
			}

		});
		studentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame1 = new JFrame("请登录");
				JButton logButton = new JButton("登录");
				frame1.setLocation(200, 50);
				frame1.setSize(250, 200);
				frame1.setLayout(new FlowLayout());
				frame1.setVisible(true);
				frame1.add(nameJLabel);
				frame1.add(nameField);
				frame1.add(passwordJLabel);
				frame1.add(passwordField);
				frame1.add(logButton);
				frame1.add(backButton);

				logButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFrame frame2 = new JFrame("2");
						JFrame frame6 = new JFrame("6");
						String n = nameField.getText();
						String p = new String(passwordField.getPassword());

						StringBuffer mBuffer = new StringBuffer();

						mBuffer.append(n);
						mBuffer.append(" ");
						mBuffer.append(p);
						System.out.println(mBuffer.toString());
						File f = new File("c:\\Users\\曹力\\Desktop\\student.txt");
						nameField.setText("");
						passwordField.setText("");
						FileReader fre;
						try {
							fre = new FileReader(f);

							BufferedReader bre = new BufferedReader(fre);

							String str = "";

							while ((str = bre.readLine()) != null) {
								String[] strs = str.split(",");
								for (int i = 0; i < strs.length; i++) {
									System.out.println(i);
									System.out.println(strs[i]);
									if (mBuffer.toString().equals(strs[i])) {

										frame6.setSize(500, 700);
										frame6.setLocation(500, 100);
										frame6.setVisible(true);

										String magString = new String("学生：" + n);

										JPanel panel1 = new JPanel();
										JPanel panel2 = new JPanel();
										JPanel panel3 = new JPanel();
										frame6.setLayout(new BorderLayout());
										frame6.add(panel1, BorderLayout.NORTH);
										frame6.add(panel2, BorderLayout.CENTER);
										frame6.add(panel3, BorderLayout.SOUTH);
										JLabel label1 = new JLabel(magString, JLabel.CENTER);

										JButton button61 = new JButton("选课");
										JButton button62 = new JButton("退课");
										JButton button63 = new JButton("打印课表");
										JButton button64 = new JButton("退出");
										JPanel panel11 = new JPanel();
										JLabel l1 = new JLabel("编号", JLabel.CENTER);
										JLabel l2 = new JLabel("课程", JLabel.CENTER);
										JLabel l3 = new JLabel("地点", JLabel.CENTER);
										JLabel l4 = new JLabel("时间", JLabel.CENTER);
										JLabel l5 = new JLabel("教师", JLabel.CENTER);
										panel1.setLayout(new BorderLayout());
										panel11.setLayout(new GridLayout(1, 5));
										panel1.add(label1, BorderLayout.NORTH);
										panel1.add(panel11, BorderLayout.SOUTH);
										panel11.add(l1);
										panel11.add(l2);
										panel11.add(l3);
										panel11.add(l4);
										panel11.add(l5);

										panel3.add(button61);
										panel3.add(button62);
										panel3.add(button63);

										File c = new File("c:\\Users\\曹力\\Desktop\\sele_course.txt");

										FileReader cou = new FileReader(c);

										BufferedReader bou = new BufferedReader(cou);

										String cString = "";
										cString = bou.readLine();

										String[] course = cString.split(",");
										panel2.setLayout(new GridLayout(course.length, 5));
										for (int j = 0; j < course.length; j++) {
											String[] courses = course[j].split(" ");
											for (int k = 0; k < 5; k++) {
												JLabel aJLabel = new JLabel(courses[k], JLabel.CENTER);
												panel2.add(aJLabel);
											}
										}
										cou.close();
										bou.close();

										button61.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												JFrame frame7 = new JFrame("7");
												frame7.setSize(500, 700);
												frame7.setLocation(500, 100);
												frame7.setVisible(true);
												frame7.setLayout(new BorderLayout());
												JPanel panel21 = new JPanel();
												JPanel panel22 = new JPanel();
												JPanel panel23 = new JPanel();
												JLabel label21 = new JLabel();
												frame7.add(panel21, BorderLayout.NORTH);
												frame7.add(panel22, BorderLayout.CENTER);
												frame7.add(panel23, BorderLayout.SOUTH);
												panel21.setLayout(new GridLayout(1, 6));
												panel21.add(label21);
												panel21.add(l1);
												panel21.add(l2);
												panel21.add(l3);
												panel21.add(l4);
												panel21.add(l5);

												File c = new File("c:\\Users\\曹力\\Desktop\\course.txt");

												FileReader cou;
												try {
													cou = new FileReader(c);
													BufferedReader bou = new BufferedReader(cou);

													String cString = "";
													cString = bou.readLine();

													String[] course = cString.split(",");
													panel22.setLayout(new GridLayout(course.length, 6));
													ButtonGroup btnGroup = new ButtonGroup();

													for (int j = 0; j < course.length; j++) {
														String aString = new String(String.valueOf(j + 1));
														JRadioButton radioButton = new JRadioButton(aString);
														panel22.add(radioButton);
														btnGroup.add(radioButton);
														String[] courses = course[j].split(" ");
														for (int k = 0; k < 5; k++) {
															JLabel aJLabel = new JLabel(courses[k], JLabel.CENTER);
															panel22.add(aJLabel);
														}
													}
													cou.close();
													bou.close();
												} catch (Exception e2) {
													// TODO Auto-generated catch block
													e2.printStackTrace();
												}

												JButton button21 = new JButton("确定");
												JButton button22 = new JButton("返回");
												panel23.add(button21);
												panel23.add(button22);
												button21.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														String jta2 = new String();
														Component[] com = panel22.getComponents();

														if (null != com) {

															for (int i = 0; i < com.length; i++) {

																if (com[i] instanceof JRadioButton) {
																	JRadioButton jrb = (JRadioButton) com[i];
																	if (jrb.isSelected()) {
																		jta2 = jrb.getText();

																	}
																}
															}
														}
														System.out.println(jta2);
														File c = new File("c:\\Users\\曹力\\Desktop\\course.txt");

														FileReader cou;
														StringBuffer courseBuffer = new StringBuffer();
														try {
															cou = new FileReader(c);
															BufferedReader bou = new BufferedReader(cou);

															String crString = "";
															crString = bou.readLine();

															String[] course = crString.split(",");
															cou.close();
															bou.close();

															try {
																// 打开一个随机访问文件流，按读写方式
																RandomAccessFile randomFile = new RandomAccessFile(
																		"c:\\Users\\曹力\\Desktop\\sele_course.txt",
																		"rw");
																// 文件长度，字节数
																long fileLength = randomFile.length();
																// 将写文件指针移到文件尾。
																randomFile.seek(fileLength);
																randomFile.writeBytes(
																		course[Integer.valueOf(jta2) - 1] + ",");
																randomFile.close();
															} catch (IOException e1) {
																e1.printStackTrace();
															}
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}

														frame7.setVisible(false);
														frame6.setVisible(false);

														frame6.remove(panel2);
														File c1 = new File("c:\\Users\\曹力\\Desktop\\sele_course.txt");

														FileReader cou1;
														try {
															cou1 = new FileReader(c1);
															BufferedReader bou = new BufferedReader(cou1);

															String cString = "";
															cString = bou.readLine();

															String[] course = cString.split(",");
															JPanel panel2 = new JPanel();
															panel2.setLayout(new GridLayout(course.length, 5));
															for (int j = 0; j < course.length; j++) {
																String[] courses = course[j].split(" ");
																for (int k = 0; k < 5; k++) {
																	JLabel aJLabel = new JLabel(courses[k],
																			JLabel.CENTER);
																	panel2.add(aJLabel);
																}
															}
															frame6.add(panel2, BorderLayout.CENTER);
															cou1.close();
															bou.close();
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}

														frame6.setVisible(true);

													}

												});

												button22.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														frame7.setVisible(false);
													}
												});

											}
										});
										button62.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												JFrame frame8 = new JFrame("8");
												frame8.setSize(500, 700);
												frame8.setLocation(500, 100);
												frame8.setVisible(true);
												frame8.setLayout(new BorderLayout());
												JPanel panel21 = new JPanel();
												JPanel panel22 = new JPanel();
												JPanel panel23 = new JPanel();
												JLabel label21 = new JLabel();
												frame8.add(panel21, BorderLayout.NORTH);
												frame8.add(panel22, BorderLayout.CENTER);
												frame8.add(panel23, BorderLayout.SOUTH);
												panel21.setLayout(new GridLayout(1, 6));
												panel21.add(label21);
												panel21.add(l1);
												panel21.add(l2);
												panel21.add(l3);
												panel21.add(l4);
												panel21.add(l5);

												File c = new File("c:\\Users\\曹力\\Desktop\\sele_course.txt");

												FileReader cou;
												try {
													cou = new FileReader(c);
													BufferedReader bou = new BufferedReader(cou);

													String cString = "";
													cString = bou.readLine();

													String[] course = cString.split(",");
													panel22.setLayout(new GridLayout(course.length, 6));
													ButtonGroup btnGroup = new ButtonGroup();

													for (int j = 0; j < course.length; j++) {
														String aString = new String(String.valueOf(j + 1));
														JRadioButton radioButton = new JRadioButton(aString);
														panel22.add(radioButton);
														btnGroup.add(radioButton);
														String[] courses = course[j].split(" ");
														for (int k = 0; k < 5; k++) {
															JLabel aJLabel = new JLabel(courses[k], JLabel.CENTER);
															panel22.add(aJLabel);
														}
													}
													cou.close();
													bou.close();
												} catch (Exception e2) {
													// TODO Auto-generated catch block
													e2.printStackTrace();
												}

												JButton button21 = new JButton("确定");
												JButton button22 = new JButton("返回");
												panel23.add(button21);
												panel23.add(button22);
												button21.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														String jta2 = new String();
														Component[] com = panel22.getComponents();

														if (null != com) {

															for (int i = 0; i < com.length; i++) {

																if (com[i] instanceof JRadioButton) {
																	JRadioButton jrb = (JRadioButton) com[i];
																	if (jrb.isSelected()) {
																		jta2 = jrb.getText();

																	}
																}
															}
														}
														System.out.println(jta2);
														File c = new File("c:\\Users\\曹力\\Desktop\\sele_course.txt");

														FileReader cou;
														StringBuffer courseBuffer = new StringBuffer();
														try {
															cou = new FileReader(c);
															BufferedReader bou = new BufferedReader(cou);

															String crString = "";
															crString = bou.readLine();

															String[] course = crString.split(",");
															cou.close();
															bou.close();
															course[Integer.valueOf(jta2) - 1] = "";

															for (int i = 0; i < course.length; i++) {
																courseBuffer.append(course[i]);

																if (course[i] == "") {
																	continue;
																} else {
																	courseBuffer.append(",");
																}

															}
															System.out.println(courseBuffer.toString());
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														FileWriter writer;
														try {
															writer = new FileWriter(c);
															writer.write(courseBuffer.toString());
															writer.flush();
															writer.close();

														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();

														}

														frame8.setVisible(false);
														frame6.setVisible(false);

														frame6.remove(panel2);
														File c1 = new File("c:\\Users\\曹力\\Desktop\\sele_course.txt");

														FileReader cou1;
														try {
															cou1 = new FileReader(c1);
															BufferedReader bou = new BufferedReader(cou1);

															String cString = "";
															cString = bou.readLine();

															String[] course = cString.split(",");
															JPanel panel2 = new JPanel();
															panel2.setLayout(new GridLayout(course.length, 5));
															for (int j = 0; j < course.length; j++) {
																String[] courses = course[j].split(" ");
																for (int k = 0; k < 5; k++) {
																	JLabel aJLabel = new JLabel(courses[k],
																			JLabel.CENTER);
																	panel2.add(aJLabel);
																}
															}
															frame6.add(panel2, BorderLayout.CENTER);
															cou1.close();
															bou.close();
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}

														frame6.setVisible(true);

													}

												});

												button22.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														frame8.setVisible(false);
													}
												});
											}

										});
										button63.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												System.out.println("编号 课程  地点 时间 教师");
												File c = new File("c:\\Users\\曹力\\Desktop\\sele_course.txt");

												FileReader cou;
												try {
													cou = new FileReader(c);
													BufferedReader bou = new BufferedReader(cou);

													String cString = "";
													cString = bou.readLine();

													String[] course = cString.split(",");
													for (int i = 0; i < course.length; i++) {
														System.out.println(course[i]);
													}
													cou.close();
													bou.close();
												} catch (Exception e2) {
													// TODO Auto-generated catch block
													e2.printStackTrace();
												}
											}
										});
										button64.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												frame1.setVisible(false);
												frame6.setVisible(false);
											}
										});

										break;
									} else {
										if (i == strs.length - 1) {
											JLabel label2 = new JLabel("请输入正确用户名、密码");
											frame2.setSize(200, 100);
											frame2.add(label2);
											frame2.setVisible(true);
										} else {
											continue;
										}
									}
								}

								System.out.println(str);
							}
							bre.close();
							fre.close();
						} catch (Exception e1) {
							// TODO: handle exception
						}
					}
				});

			}
		});
		sign_inButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame9 = new JFrame("9");
				JPanel panel91 = new JPanel();
				JPanel panel92 = new JPanel();
				JButton button91 = new JButton("注册");
				JButton button92 = new JButton("返回");
				JLabel label91 = new JLabel("用户名");
				JLabel label92 = new JLabel("密码");
				JLabel label93 = new JLabel("确认密码");
				JTextField nameField = new JTextField(20);
				JPasswordField passwordField = new JPasswordField(20);
				JPasswordField passwordField2 = new JPasswordField(20);
				frame9.setLocation(200, 50);
				frame9.setSize(250, 300);
				frame9.setLayout(new BorderLayout());
				frame9.setVisible(true);
				panel91.setLayout(new FlowLayout());
				panel91.add(label91);
				panel91.add(nameField);
				panel91.add(label92);
				panel91.add(passwordField);
				panel91.add(label93);
				panel91.add(passwordField2);
				frame9.add(panel91, BorderLayout.CENTER);
				panel92.add(button91);
				panel92.add(button92);
				frame9.add(panel92, BorderLayout.SOUTH);
				button91.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String name = nameField.getText();
						String password = new String(passwordField.getPassword());
						String password2 = new String(passwordField2.getPassword());
						if (password.equals(password2)) {
							try {
								// 打开一个随机访问文件流，按读写方式
								RandomAccessFile randomFile = new RandomAccessFile(
										"c:\\Users\\曹力\\Desktop\\student.txt", "rw");
								// 文件长度，字节数
								long fileLength = randomFile.length();
								// 将写文件指针移到文件尾。
								randomFile.seek(fileLength);
								randomFile.writeBytes(name + " " + password + ",");
								randomFile.close();
								frame9.setVisible(false);
								JFrame aFrame = new JFrame();
								aFrame.setLocation(200, 50);
								aFrame.setSize(100, 100);
								aFrame.setVisible(true);
								JLabel aJLabel = new JLabel("注册成功，请返回登录");
								aFrame.add(aJLabel);
								JButton aButton = new JButton("返回");
								aFrame.add(aButton);
								aButton.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										aFrame.setVisible(false);
									}
								});
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}

					}
				});

				button92.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame9.setVisible(false);
					}
				});
			}

		});

	}

	public static void main(String args[]) {
		gui_one tGui_one = new gui_one("测试");
		tGui_one.setSize(250, 250);
		tGui_one.setVisible(true);
	}
}
