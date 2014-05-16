Struts2自定义类型的Date转换器

    用户提交表单的时候，常常涉及到日期的提交，例如“1992-07-31”, 由于在http传输信息的时候是以string来传递的，这样可能对应属性的时候不是Date类型不方便我们处理，所以我们常常需要自定义Date类型转换器将string和date类型进行相互转换。

Step1:
  首先建立一个Person类，它的birthday属性类型为Date,设置相应的get,set方法。

Step2:
  设置Action类，这里是ConverterAction类，把Person person作为私有属性,这个person名字对应input的name,这样提交的input内容就会到person中来, 设置person对象的get, set方法, submit的时候会自动调用, extends ActionSupport 会自动执行execute函数, 返回SUCESS, 直接跳转到success.jsp

Step3:
  PersonConverter类, extends StrutsTypeConverter类, 实现convertFromString和convertToString两个函数, 成功的时候返回Person对象。

Step4:
  ConverterAction-conversion.properties文件配置,本例实现的转换器是局部的,
person = PersonConverter

Step5:
  提交页面 input name为 person 对应Action类中的person对象, success.jsp 使用struts2标签 person.birthday取出转化之后的属性即可。