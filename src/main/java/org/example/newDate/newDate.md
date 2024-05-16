
 
JDK 8新增的时间API，主要是线程安全，位于java.time包下 
# 新时间api
- LocalDate ：表示日期，包含年月日，格式为 2019-10-16 
- LocalTime ：表示时间，包含时分秒，格式为 16:38:54.158549300 
- LocalDateTime ：表示日期时间，包含年月日，时分秒，格式为 2018-09-06T15:33:56.750 
- DateTimeFormatter ：日期时间格式化类。 
- Instant：时间戳，表示一个特定的时间瞬间。 
- Duration：用于计算2个时间(LocalTime，时分秒)的距离 
- Period：用于计算2个日期(LocalDate，年月日)的距离 
- ZonedDateTime ：包含时区的时间


"Java中使用的历法是ISO 8601日历系统，它是世界民用历法，也就是我们所说的公历。平年有365天，闰年是366
天。此外Java 8还提供了4套其他历法，分别是："
- ThaiBuddhistDate ：泰国佛教历 
- MinGuo Date ：中华民国历 
- JapaneseDate :日本
- HiRahDate ：伊斯兰



# 目录

[DateOrDate.java](DateOrDate.java)
1. test01 日期比较
2. test02 时间格式化与解析
3. 
[InstantDemo01.java](InstantDemo01.java)
1. test01 时间戳 APi Instant
2. test02 JDK 8的计算日期时间差类 Duration/Period类: 计算日期时间差。
3. test03 时间矫正器 TemporalAdjuster

[LocalDemo01.java](LocalDemo01.java)
1. test01   LocalDate:获取日期时间的信息。格式为 2019-10-16,yyyy-MM-dd(经常使用)
2. test02   LocalTime:获取日期时间的信息。格式为 16:38:54.158549300,HH:mm:ss(经常使用)
3. test03   LocalDateTime :获取日期时间的信息。LocalDateTime格式为yyyy-mm-ddTHH:mm:ss.n(经常使用)
4. test04   对日期时间的修改 ,最简单的方式是使用withAttribute方法:格式化日期时间。



# 总结
1. 新版的日期和时间API中，日期和时间对象是不可变的。操纵的日期不会影响老值，而是新生成一个实例。
2. 新的API提供了两种不同的时间表示方式，有效地区分了人和机器的不同需求。
3. TemporalAdjuster可以更精确的操纵日期，还可以自定义日期调整器。
4. 是线程安全的
