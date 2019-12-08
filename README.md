# java实验报告5
### 综合性实验 学生选课系统设计 大数据181 曹力 2018310985 
+ 实验目的
  + 分析学生选课系统
  + 使用GUI窗体及其组件设计窗体界面
  + 完成学生选课过程业务逻辑编程
  + 基于文件保存并读取数据
  + 异常处理
+ 实验要求
  + 一、系统角色分析及类设计
    + 例如：学校由“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
    + 定义每种角色人员的属性，及其操作方法
    + 属性示例：
      + 人员（编号、姓名、性别……）
      + 教师（编号、姓名、性别、所授课程……）
      + 学生（编号、姓名、性别、所选课程……）
      + 课程（编号、课程名称、上课地点、时间、授课教师……）
  + 二、要求：
    + 1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表。
    + 2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
    + 3、针对操作过程中可能会出现的各种异常，做异常处理。
    + 4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
    + 5、基于Github.com提交实验，包括实验SRC源文件加程序、README.md实验报告文档。
#### 流程图
![](https://github.com/2018310985/Java5/blob/master/流程图.jpg)

#### 实验内容
首先建立客户端窗体：
![](https://github.com/2018310985/Java5/blob/master/image/1.png)
  
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
    
点击管理端：
输入管理员用户名密码，管理员用户名密码存在manage.txt中

![](https://github.com/2018310985/Java5/blob/master/image/2.png)
![](https://github.com/2018310985/Java5/blob/master/image/3.png)
    
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

						while ((str = bre.readLine()) != null) 
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
                  
通过点击loginButton按钮，触发上述事件。获取输入框文字，与文件中已保存的用户名密码匹配，若匹配成功则弹出如下窗体

![](https://github.com/2018310985/Java5/blob/master/image/4.png)

若用户名密码错误则弹出

![](https://github.com/2018310985/Java5/blob/master/image/5.png)
    
    else {
			if (i == strs.length - 1) {
				JLabel label2 = new JLabel("请输入正确用户名、密码");
				frame2.setSize(200, 100);
				frame2.add(label2);
				frame2.setVisible(true);
			} else {
					continue;
		  }
      
点击创建课程，会弹出供管理员添加课程信息的窗体

![](https://github.com/2018310985/Java5/blob/master/image/6.png)
  
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
         
点击“创建”按钮，文件与前方面板会同时更新新添加的课程：

![](https://github.com/2018310985/Java5/blob/master/image/7.png)

![](https://github.com/2018310985/Java5/blob/master/image/8.png)

![](https://github.com/2018310985/Java5/blob/master/image/9.png)

![](https://github.com/2018310985/Java5/blob/master/image/10.png)

    button2.addActionListener(new ActionListener() {

		  @Override
			public void actionPerformed(ActionEvent e) {
			  // TODO Auto-generated method stub
				JFrame frame5 = new JFrame("5");
         ......

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
          
点击“删除课程”弹出如下窗体，点击课程前方按钮，删除对应课程

![](https://github.com/2018310985/Java5/blob/master/image/11.png)

	JButton button21 = new JButton("确定");
	JButton button22 = new JButton("返回");
	panel23.add(button21);
	panel23.add(button22);
	button21.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		/ TODO Auto-generated method stub
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
			courseBuffer.append(course[i]);													if (course[i] == "") {
				continue;														} else {
				courseBuffer.append(",");
			}
		}
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
	} catch (Exception e1) {														// TODO Auto-generated catch block
		e1.printStackTrace();
	}
![](https://github.com/2018310985/Java5/blob/master/image/12.png)
![](https://github.com/2018310985/Java5/blob/master/image/13.png)

至此，管理端结束
进入学生模块

点击学生注册，将验证“密码”与“确认密码”是否相同
相同则注册成功

![](https://github.com/2018310985/Java5/blob/master/image/14.png)

将输入的用户名密码保存在student.txt中
	
	if (password.equals(password2)) {
		try {
			RandomAccessFile randomFile = new RandomAccessFile("c:\\Users\\曹力\\Desktop\\student.txt", "rw");
			long fileLength = randomFile.length();
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
	
点击学生端 与管理端相同的界面，验证方法相似，因此不做过多解释

![](https://github.com/2018310985/Java5/blob/master/image/15.png)

登录，弹出已选课程页面

![](https://github.com/2018310985/Java5/blob/master/image/16.png)

点击“选课”，进入选课页面，无论是“选课”还是“退课”都是从管理端“删除课程”那复制过来在改一改的代码就不贴了

![](https://github.com/2018310985/Java5/blob/master/image/17.png)
![](https://github.com/2018310985/Java5/blob/master/image/18.png)
![](https://github.com/2018310985/Java5/blob/master/image/19.png)

选择退课

![](https://github.com/2018310985/Java5/blob/master/image/20.png)
![](https://github.com/2018310985/Java5/blob/master/image/21.png)

打印课表输出于控制台

![](https://github.com/2018310985/Java5/blob/master/image/22.png)

####心得体会
这次实验的代码量是我学习以来最多了，压力很大，但却是增加了我的熟练度。代码量多的一个重要原因是我有三大段重复代码，我认为这完全可以通过调用来精简，但时间太少，我选择了轻松简单的Ctrl+C Ctrl+V
而且代码总会莫名报错，前一天刚敲好时能正常运行，过两天回来再看就不行了，时间太紧，没法挑了
