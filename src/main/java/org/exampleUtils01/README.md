

 

#### [BigDecimalUtils](BigDecimalUtils) 钱币工具类
#### [datavalidator](datavalidator) 数据校验工具类
#### [dateUtils](dateUtils) 日期工具类
#### [encryptionUtils](encryptionUtils) 加密相关工具类
#### [enumUtils](enumUtils) 枚举工具类
#### [exception](exception) 异常工具类
#### [memcachedUtils](memcachedUtils) memcached工具类
#### [poi](poi) poi工具类
#### [qRcode](qRcode) 二维码工具类  代办 @TODO
#### [regexUtils](regexUtils)  手机号校验
### [StringUtils](StringUtils) 字符串工具类



- 静态类式：
  - 工具方法设计为static方法
  - 工具 类所有构造方法都设计为private修饰
  - 工具类本身以abstract修饰（目的就是只能用类调用方法,不能实例化)
- 单例模式:
  - 工具方法都设为非static方法~~~~
  - 将工具类设计为单列模式
  - 注意这种方式需要获取工具类对象(实例化)才能调用方法
- 静态类优势：

  - 静态类不用引用就能调用，而单例需要有对象的引用，因此节约资源（我觉得这个影响微乎其微，可以忽略）
  - 静态类方便，随处可用；而单例必须有引用，需要注入或者new（是有点麻烦，我上次写静态类也是因为这个原因）
- 单件类优势：
  - 单例模式的类是普通的类，它具有面向对象的特性，方便扩展
  - 对于有配置的工具类，可以轻松的创建多个不同配置的单例对象（想起我主导的另一个项目就存在5-6个redis数据源，如果使用静态类就是灾难）
    结论：

如果没有配置信息的工具类，当然是静态类好，随处调用，不需引用爽得不要不要的。
比如Math.abs()，如果写个单例，可能全世界都要笑话你了。
如果有配置信息的工具类，最好还是使用单例模式吧，这样以后如果有多个数据源，
你会感谢你自己