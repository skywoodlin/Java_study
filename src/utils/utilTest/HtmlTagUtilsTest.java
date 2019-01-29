package utils.utilTest;

import org.junit.Test;
import utils.RegexUtils;

/**
 * Created by xjlin on 2018/11/26.
 */
public class HtmlTagUtilsTest{
    @Test
    public void testFindTags() {
        String text1 =
                "\n" +
                        "\n" +
                        "<!DOCTYPE html>\n" +
                        "<html lang=\"zh-cn\">\n" +
                        "<head>\n" +
                        "<meta charset=\"utf-8\"/>\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                        "<meta name=\"referrer\" content=\"origin\" />\n" +
                        "<title>JAVA正则表达式：Pattern类与Matcher类详解(转) - ggjucheng - 博客园</title>\n" +
                        "<meta property=\"og:description\" content=\"java.util" +
                        ".regex是一个用正则表达式所订制的模式来对字符串进行匹配工作的类库包。它包括两个类：Pattern和Matcher Pattern 一个Pattern是一个正则表达式经编译后的表\" />\n" +
                        "<link type=\"text/css\" rel=\"stylesheet\" href=\"/bundles/blog-common" +
                        ".css?v=-duj5vpGTntb85GJoM3iRI972XwWcI-j8zmqDzyfu2w1\"/>\n" +
                        "<link id=\"MainCss\" type=\"text/css\" rel=\"stylesheet\" href=\"/skins/Cogitation/bundle-Cogitation" +
                        ".css?v=KxzCsGje7vptXKdp2HZBpXmgRp_h-PvgHFxMy8F9r3o1\"/>\n" +
                        "<link id=\"mobile-style\" media=\"only screen and (max-width: 767px)\" type=\"text/css\" " +
                        "rel=\"stylesheet\" href=\"/skins/Cogitation/bundle-Cogitation-mobile" +
                        ".css?v=oTjri5RX_QRtLNHcaESDEdMPbu1XWWdEv3lmk8oEazU1\"/>\n" +
                        "<link title=\"RSS\" type=\"application/rss+xml\" rel=\"alternate\" href=\"https://www.cnblogs" +
                        ".com/ggjucheng/rss\"/>\n" +
                        "<link title=\"RSD\" type=\"application/rsd+xml\" rel=\"EditURI\" href=\"https://www.cnblogs" +
                        ".com/ggjucheng/rsd.xml\"/>\n" +
                        "<link type=\"application/wlwmanifest+xml\" rel=\"wlwmanifest\" href=\"https://www.cnblogs" +
                        ".com/ggjucheng/wlwmanifest.xml\"/>\n" +
                        "<script src=\"//common.cnblogs.com/scripts/jquery-2.2.0.min.js\"></script>\n" +
                        "<script type=\"text/javascript\">var currentBlogApp = 'ggjucheng', cb_enable_mathjax=false;var " +
                        "isLogined=true;</script>\n" +
                        "<script src=\"/bundles/blog-common.js?v=oVrWjmbP-rXxVp7O71kev8vWEZCetdwYaIziKHJCYc41\" " +
                        "type=\"text/javascript\"></script>\n" +
                        "<style type=\"text/css\">\n" +
                        "[id^=\"ad_\"] {display:none!important;display:none}</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<a name=\"top\"></a>\n" +
                        "\n" +
                        "<div id=\"top\">\n" +
                        "\t\n" +
                        "<div>\n" +
                        "\t<table>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td class=\"HeaderTitles\">\n" +
                        "\t\t\t\t<h1 class=\"HeaderTitle\"><a id=\"Header1_HeaderTitle\" class=\"HeaderMainTitle\" " +
                        "href=\"https://www.cnblogs.com/ggjucheng/\">简单，可复制</a></h1>\n" +
                        "\t\t\t\t<p id=\"tagline\">点点滴滴，尽在文中</p>\n" +
                        "\t\t\t</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</table>\n" +
                        "</div>\n" +
                        "<div class=\"HeaderBar\">\n" +
                        "\t<table id=\"HeaderBar\" class=\"HeaderBar\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td class=\"HeaderBarTab\" nowrap>\n" +
                        "&nbsp;\n" +
                        " ::\n" +
                        "<a id=\"blog_nav_myhome\" href=\"https://www.cnblogs.com/ggjucheng/\">首页</a> ::\n" +
                        "<a href=\"http://q.cnblogs.com\" class=\"menu\">博问</a> ::\n" +
                        "<a href=\"http://home.cnblogs.com/ing/\" class=\"menu\">闪存</a> ::\n" +
                        "<a id=\"blog_nav_newpost\" rel=\"nofollow\" href=\"https://i.cnblogs.com/EditPosts" +
                        ".aspx?opt=1\">新随笔</a> ::\n" +
                        "<a id=\"blog_nav_contact\" accesskey=\"9\" rel=\"nofollow\" href=\"https://msg.cnblogs" +
                        ".com/send/ggjucheng\">联系</a> ::\n" +
                        "<a id=\"blog_nav_rss\" href=\"https://www.cnblogs.com/ggjucheng/rss\">订阅</a>\n" +
                        "<a id=\"blog_nav_rss_image\" class=\"XMLLink\" href=\"https://www.cnblogs.com/ggjucheng/rss\"><img " +
                        "src=\"//www.cnblogs.com/images/xml.gif\" alt=\"订阅\" /></a> ::\n" +
                        "<a id=\"blog_nav_admin\" rel=\"nofollow\" href=\"https://i.cnblogs.com/\">管理</a> ::\n" +
                        "\n" +
                        "</td>\n" +
                        "\t\t\t<td><img id=\"Header1_BlueTab\" src=\"/skins/Cogitation/Images/BlueTabRight.gif\" " +
                        "align=\"absmiddle\" /></td>\n" +
                        "\t\t\t<td class=\"HeaderBarTabBack\" nowrap width=\"100%\">\n" +
                        "\t\t\t\t<div id=\"blog_stats\">\n" +
                        "<div class=\"BlogStatsBar\">\n" +
                        "\t<table class=\"BlogStatsBar\">\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td width=\"100%\">\n" +
                        "\t\t\t</td>\n" +
                        "\t\t\t<td class=\"BlogStatsBar\" nowrap>\n" +
                        "\t\t\t\t&nbsp;\n" +
                        "\t\t\t\t431 \n" +
                        "\t\t\t\t随笔&nbsp;::\n" +
                        "\t\t\t\t0 文章\n" +
                        "\t\t\t\t::\n" +
                        "\t\t\t\t546 评论\n" +
                        "\t\t\t\t::\n" +
                        "\t\t\t\t0 引用\n" +
                        "\t\t\t</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</table>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "\t\t\t</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</table>\n" +
                        "</div>\n" +
                        "\n" +
                        "</div>\n" +
                        "<div id=\"leftmenu\">\t\n" +
                        "\n" +
                        "\t    <div id=\"blog-calendar\" style=\"display:none\"></div><script " +
                        "type=\"text/javascript\">loadBlogDefaultCalendar();</script>\n" +
                        "\t\t\n" +
                        "<h3>公告</h3>\n" +
                        "<div class=\"News\">\n" +
                        "\t<div id=\"blog-news\"></div><script type=\"text/javascript\">loadBlogNews();</script>\n" +
                        "</div>\n" +
                        "\n" +
                        "\t\t<div id=\"blog-sidecolumn\"></div><script type=\"text/javascript\">loadBlogSideColumn();" +
                        "</script>\n" +
                        "\t\n" +
                        "</div>\n" +
                        "<div id=\"main\">\n" +
                        "\t\n" +
                        "<div id=\"post_detail\">\n" +
                        "<div class=\"post\">\n" +
                        "\t<div class=\"postTitle\">\n" +
                        "\t\t<a id=\"cb_post_title_url\" href=\"https://www.cnblogs.com/ggjucheng/p/3423731" +
                        ".html\">JAVA正则表达式：Pattern类与Matcher类详解(转)</a>\n" +
                        "\t</div>\n" +
                        "\t\n" +
                        "\t<div class=\"postText\">\n" +
                        "\t\t<div id=\"cnblogs_post_body\" class=\"blogpost-body\"><div>java.util" +
                        ".regex是一个用正则表达式所订制的模式来对字符串进行匹配工作的类库包。它包括两个类：Pattern和Matcher Pattern 一个Pattern是一个正则表达式经编译后的表现模式。 " +
                        "Matcher 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。 " +
                        "首先一个Pattern实例订制了一个所用语法与PERL的类似的正则表达式经编译后的模式，然后一个Matcher实例在这个给定的Pattern实例的模式控制下进行字符串的匹配工作。</div>\n" +
                        "<div>&nbsp;</div>\n" +
                        "<div>\n" +
                        "<p>以下我们就分别来看看这两个类：</p>\n" +
                        "<p><span><strong>一、捕获组的概念</strong></span></p>\n" +
                        "<p>捕获组可以通过从左到右计算其开括号来编号，编号是从1 开始的。例如，在表达式 ((A)(B(C)))中，存在四个这样的组：</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>1<span style=\"color: #000000;\">        ((A)(B(C)))\n" +
                        "</span>2<span style=\"color: #000000;\">        (A)\n" +
                        "</span>3<span style=\"color: #000000;\">        (B(C))\n" +
                        "</span>4        (C)</pre>\n" +
                        "</div>\n" +
                        "<p><span>组零始终代表整个表达式。 以 (?) 开头的组是纯的非捕获 组，它不捕获文本，也不针对组合计进行计数。</span><br /><br " +
                        "/>与组关联的捕获输入始终是与组最近匹配的子序列。如果由于量化的缘故再次计算了组，则在第二次计算失败时将保留其以前捕获的值（如果有的话）例如，将字符串\"aba\" 与表达式(a(b)?)+ " +
                        "相匹配，会将第二组设置为 \"b\"。在每个匹配的开头，所有捕获的输入都会被丢弃。</p>\n" +
                        "<p><br /><strong><br /></strong><span><strong>二、详解Pattern类和Matcher类</strong></span><br /><br " +
                        "/>java正则表达式通过java.util.regex包下的Pattern类与Matcher类实现(建议在阅读本文时,打开java API文档,当介绍到哪个方法时,查看java API中的方法说明," +
                        "效果会更佳).&nbsp;<br />Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,但可以通过Pattern.complie(String " +
                        "regex)简单工厂方法创建一个正则表达式,&nbsp;<br />Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\w+\"<span style=\"color: #000000;\">); \n" +
                        "p.pattern();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回 \\w+ " +
                        "</span></pre>\n" +
                        "</div>\n" +
                        "<p>pattern() 返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数<br /><br /><strong>1.Pattern" +
                        ".split(CharSequence input)</strong></p>\n" +
                        "<p>Pattern有一个split(CharSequence input)方法,用于分隔字符串,并返回一个String[],我猜String.split(String regex)就是通过Pattern" +
                        ".split(CharSequence input)来实现的.&nbsp;<br />Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "String[] str</span>=p.split(\"我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com\"); </pre>\n" +
                        "</div>\n" +
                        "<p>结果:str[0]=\"我的QQ是:\" str[1]=\"我的电话是:\" str[2]=\"我的邮箱是:aaa@aaa.com\"&nbsp;<br /><strong><br />2" +
                        ".Pattern.matcher(String regex,CharSequence input)是一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串" +
                        ".</strong></p>\n" +
                        "<p>&nbsp;</p>\n" +
                        "<p>Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern.matches(\"\\\\d+\",\"2223\");<span style=\"color: #008000;\">//</span><span " +
                        "style=\"color: #008000;\">返回true </span>\n" +
                        "Pattern.matches(\"\\\\d+\",\"2223aa\");<span style=\"color: #008000;\">//</span><span style=\"color: " +
                        "#008000;\">返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到 </span>\n" +
                        "Pattern.matches(\"\\\\d+\",\"22bb23\");<span style=\"color: #008000;\">//</span><span style=\"color: " +
                        "#008000;\">返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到 </span></pre>\n" +
                        "</div>\n" +
                        "<p>&nbsp;</p>\n" +
                        "<p><strong>3.Pattern.matcher(CharSequence input)</strong></p>\n" +
                        "<p>说了这么多,终于轮到Matcher类登场了,Pattern.matcher(CharSequence input)返回一个Matcher对象.<br />Matcher类的构造方法也是私有的," +
                        "不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.&nbsp;<br />Pattern类只能做一些简单的匹配操作," +
                        "要想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作.Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.&nbsp;<br " +
                        "/>Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"22bb23\"<span style=\"color: #000000;\">); \n" +
                        "m.pattern();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回p " +
                        "也就是返回该Matcher对象是由哪个Pattern对象的创建的 </span></pre>\n" +
                        "</div>\n" +
                        "<p><strong>4.Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()</strong></p>\n" +
                        "<p>Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false&nbsp;<br />matches()对整个字符串进行匹配," +
                        "只有整个字符串都匹配了才返回true&nbsp;<br />Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"22bb23\"<span style=\"color: #000000;\">); \n" +
                        "m.matches();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回false," +
                        "因为bb不能被\\d+匹配,导致整个字符串匹配未成功. </span>\n" +
                        "Matcher m2=p.matcher(\"2223\"<span style=\"color: #000000;\">); \n" +
                        "m2.matches();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回true," +
                        "因为\\d+匹配到了整个字符串</span></pre>\n" +
                        "</div>\n" +
                        "<p>我们现在回头看一下Pattern.matcher(String regex,CharSequence input),它与下面这段代码等价&nbsp;<br />Pattern.compile" +
                        "(regex).matcher(input).matches()&nbsp;<br /><br />lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true&nbsp;<br" +
                        " />Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"22bb23\"<span style=\"color: #000000;\">); \n" +
                        "m.lookingAt();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回true," +
                        "因为\\d+匹配到了前面的22 </span>\n" +
                        "Matcher m2=p.matcher(\"aa2223\"<span style=\"color: #000000;\">); \n" +
                        "m2.lookingAt();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;" +
                        "\">返回false,因为\\d+不能匹配前面的aa </span></pre>\n" +
                        "</div>\n" +
                        "<p>find()对字符串进行匹配,匹配到的字符串可以在任何位置.&nbsp;<br />Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"22bb23\"<span style=\"color: #000000;\">); \n" +
                        "m.find();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回true " +
                        "</span>\n" +
                        "Matcher m2=p.matcher(\"aa2223\"<span style=\"color: #000000;\">); \n" +
                        "m2.find();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回true " +
                        "</span>\n" +
                        "Matcher m3=p.matcher(\"aa2223bb\"<span style=\"color: #000000;\">); \n" +
                        "m3.find();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回true " +
                        "</span>\n" +
                        "Matcher m4=p.matcher(\"aabb\"<span style=\"color: #000000;\">); \n" +
                        "m4.find();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回false " +
                        "</span></pre>\n" +
                        "</div>\n" +
                        "<p>&nbsp;</p>\n" +
                        "<p><strong>5.Mathcer.start()/ Matcher.end()/ Matcher.group()</strong></p>\n" +
                        "<p>当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.&nbsp;<br />start()返回匹配到的子字符串在字符串中的索引位置" +
                        ".&nbsp;<br />end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.&nbsp;<br />group()返回匹配到的子字符串&nbsp;<br />Java代码示例:&nbsp;" +
                        "</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"aaa2223bb\"<span style=\"color: #000000;\">); \n" +
                        "m.find();</span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">匹配2223 " +
                        "</span>\n" +
                        "m.start();<span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回3 </span>\n" +
                        "m.end();<span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回7,返回的是2223后的索引号 " +
                        "</span>\n" +
                        "m.group();<span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回2223 </span>\n" +
                        "<span style=\"color: #000000;\">\n" +
                        "Mathcer m2</span>=m.matcher(\"2223bb\"<span style=\"color: #000000;\">); \n" +
                        "m.lookingAt();   </span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;" +
                        "\">匹配2223 </span>\n" +
                        "m.start();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回0,由于lookingAt" +
                        "()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0 </span>\n" +
                        "m.end();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回4 </span>\n" +
                        "m.group();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回2223 </span>\n" +
                        "<span style=\"color: #000000;\">\n" +
                        "Matcher m3</span>=m.matcher(\"2223bb\"<span style=\"color: #000000;\">); \n" +
                        "m.matches();   </span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">匹配整个字符串" +
                        " </span>\n" +
                        "m.start();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回0,原因相信大家也清楚了 " +
                        "</span>\n" +
                        "m.end();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回6,原因相信大家也清楚了," +
                        "因为matches()需要匹配所有字符串 </span>\n" +
                        "m.group();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回2223bb " +
                        "</span></pre>\n" +
                        "</div>\n" +
                        "<p>说了这么多,相信大家都明白了以上几个方法的使用,该说说正则表达式的分组在java中是怎么使用的.&nbsp;<br />start(),end(),group()均有一个重载方法它们是start" +
                        "(int i),end(int i),group(int i)专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.&nbsp;<br />Java代码示例:&nbsp;" +
                        "</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"([a-z]+)(\\\\d+)\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"aaa2223bb\"<span style=\"color: #000000;\">); \n" +
                        "m.find();   </span><span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">匹配aaa2223 " +
                        "</span>\n" +
                        "m.groupCount();   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回2,因为有2组 " +
                        "</span>\n" +
                        "m.start(1);   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回0 " +
                        "返回第一组匹配到的子字符串在字符串中的索引号 </span>\n" +
                        "m.start(2);   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回3 </span>\n" +
                        "m.end(1);   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回3 " +
                        "返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置. </span>\n" +
                        "m.end(2);   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回7 </span>\n" +
                        "m.group(1);   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回aaa," +
                        "返回第一组匹配到的子字符串 </span>\n" +
                        "m.group(2);   <span style=\"color: #008000;\">//</span><span style=\"color: #008000;\">返回2223," +
                        "返回第二组匹配到的子字符串 </span></pre>\n" +
                        "</div>\n" +
                        "<p>现在我们使用一下稍微高级点的正则匹配操作,例如有一段文本,里面有很多数字,而且这些数字是分开的,我们现在要将文本中所有数字都取出来,利用java的正则操作是那么的简单.&nbsp;<br " +
                        "/>Java代码示例:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>Pattern p=Pattern.compile(\"\\\\d+\"<span style=\"color: #000000;\">); \n" +
                        "Matcher m</span>=p.matcher(\"我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com\"<span style=\"color: " +
                        "#000000;\">); \n" +
                        "</span><span style=\"color: #0000ff;\">while</span><span style=\"color: #000000;\">(m.find()) { \n" +
                        "     System.out.println(m.group()); \n" +
                        "} </span></pre>\n" +
                        "</div>\n" +
                        "<p>输出:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>456456 \n" +
                        "0532214 \n" +
                        "123 </pre>\n" +
                        "</div>\n" +
                        "<p>&nbsp;</p>\n" +
                        "<p>如将以上while()循环替换成&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre><span style=\"color: #0000ff;\">while</span><span style=\"color: #000000;\">(m.find()) { \n" +
                        "     System.out.println(m.group()); \n" +
                        "     System.out.print(</span>\"start:\"+<span style=\"color: #000000;\">m.start()); \n" +
                        "     System.out.println(</span>\" end:\"+<span style=\"color: #000000;\">m.end()); \n" +
                        "} </span></pre>\n" +
                        "</div>\n" +
                        "<p>则输出:&nbsp;</p>\n" +
                        "<div class=\"cnblogs_code\">\n" +
                        "<pre>456456<span style=\"color: #000000;\"> \n" +
                        "start:</span>6 end:12 \n" +
                        "0532214<span style=\"color: #000000;\"> \n" +
                        "start:</span>19 end:26 \n" +
                        "123<span style=\"color: #000000;\"> \n" +
                        "start:</span>36 end:39 </pre>\n" +
                        "</div>\n" +
                        "<p>现在大家应该知道,每次执行匹配操作后start(),end(),group()三个方法的值都会改变,改变成匹配到的子字符串的信息,以及它们的重载方法,也会改变成相应的信息.&nbsp;<br " +
                        "/>注意:只有当匹配操作成功,才可以使用start(),end(),group()三个方法,否则会抛出java.lang.IllegalStateException,也就是当matches()," +
                        "lookingAt(),find()其中任意一个方法返回true时,才可以使用.</p>\n" +
                        "<p>&nbsp;</p>\n" +
                        "<p>转自&nbsp;<a href=\"http://www.kaiyuanba.cn/html/1/131/138/7609.htm\">http://www.kaiyuanba" +
                        ".cn/html/1/131/138/7609.htm</a></p>\n" +
                        "\n" +
                        "</div></div><div id=\"MySignature\"></div>\n" +
                        "<div class=\"clear\"></div>\n" +
                        "<div id=\"blog_post_info_block\">\n" +
                        "<div id=\"BlogPostCategory\"></div>\n" +
                        "<div id=\"EntryTag\"></div>\n" +
                        "<div id=\"blog_post_info\">\n" +
                        "</div>\n" +
                        "<div class=\"clear\"></div>\n" +
                        "<div id=\"post_next_prev\"></div>\n" +
                        "</div>\n" +
                        "\n" +
                        "\n" +
                        "\t</div>\n" +
                        "\t\n" +
                        "\t<div class=\"postfoot\">\n" +
                        "\t\tposted on <span id=\"post-date\">2013-11-14 17:38</span> <a href='https://www.cnblogs" +
                        ".com/ggjucheng/'>ggjucheng</a> 阅读(<span id=\"post_view_count\">...</span>) 评论(<span " +
                        "id=\"post_comment_count\">...</span>)  <a href =\"https://i.cnblogs.com/EditPosts" +
                        ".aspx?postid=3423731\" rel=\"nofollow\">编辑</a> <a href=\"#\" onclick=\"AddToWz(3423731);return false;" +
                        "\">收藏</a>\n" +
                        "\t</div>\n" +
                        "</div>\n" +
                        "<script type=\"text/javascript\">var allowComments=true,cb_blogId=104392,cb_entryId=3423731," +
                        "cb_blogApp=currentBlogApp,cb_blogUserGuid='d3935eec-4025-e111-b422-842b2b196315'," +
                        "cb_entryCreatedDate='2013/11/14 17:38:00';loadViewCount(cb_entryId);var cb_postType=1;</script>\n" +
                        "\n" +
                        "</div><a name=\"!comments\"></a><div id=\"blog-comments-placeholder\"></div><script " +
                        "type=\"text/javascript\">var commentManager = new blogCommentManager();commentManager.renderComments" +
                        "(0);</script>\n" +
                        "<div id='comment_form' class='commentform'>\n" +
                        "<a name='commentform'></a>\n" +
                        "<div id='divCommentShow'></div>\n" +
                        "<div id='comment_nav'><span id='span_refresh_tips'></span><a href='javascript:void(0);' " +
                        "onclick='return RefreshCommentList();' id='lnk_RefreshComments' runat='server' " +
                        "clientidmode='Static'>刷新评论</a><a href='#' onclick='return RefreshPage();'>刷新页面</a><a " +
                        "href='#top'>返回顶部</a></div>\n" +
                        "<div id='comment_form_container'></div>\n" +
                        "<div class='ad_text_commentbox' id='ad_text_under_commentbox'></div>\n" +
                        "<div id='ad_t2'></div>\n" +
                        "<div id='opt_under_post'></div>\n" +
                        "<div id='cnblogs_c1' class='c_ad_block'></div>\n" +
                        "<div id='under_post_news'></div>\n" +
                        "<script async='async' src='https://www.googletagservices.com/tag/js/gpt.js'></script>\n" +
                        "<script>\n" +
                        "  var googletag = googletag || {};\n" +
                        "  googletag.cmd = googletag.cmd || [];\n" +
                        "</script>\n" +
                        "\n" +
                        "<script>\n" +
                        "  googletag.cmd.push(function() {\n" +
                        "    googletag.defineSlot('/1090369/C2', [468, 60], 'div-gpt-ad-1539008685004-0').addService(googletag" +
                        ".pubads());\n" +
                        "    googletag.pubads().enableSingleRequest();\n" +
                        "    googletag.enableServices();\n" +
                        "  });\n" +
                        "</script>\n" +
                        "<div id='cnblogs_c2' class='c_ad_block'>\n" +
                        "    <div id='div-gpt-ad-1539008685004-0' style='height:60px; width:468px;'>\n" +
                        "    <script>\n" +
                        "    if (new Date() >= new Date(2018, 9, 13)) {\n" +
                        "        googletag.cmd.push(function() { googletag.display('div-gpt-ad-1539008685004-0'); });\n" +
                        "    }\n" +
                        "    </script>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "<div id='under_post_kb'></div>\n" +
                        "<div id='HistoryToday' class='c_ad_block'></div>\n" +
                        "<script type='text/javascript'>\n" +
                        "    fixPostBody();\n" +
                        "    setTimeout(function () { incrementViewCount(cb_entryId); }, 50);\n" +
                        "    deliverAdT2();\n" +
                        "    deliverAdC1();\n" +
                        "    deliverAdC2();    \n" +
                        "    loadNewsAndKb();\n" +
                        "    loadBlogSignature();\n" +
                        "    LoadPostInfoBlock(cb_blogId, cb_entryId, cb_blogApp, cb_blogUserGuid);\n" +
                        "    GetPrevNextPost(cb_entryId, cb_blogId, cb_entryCreatedDate, cb_postType);\n" +
                        "    loadOptUnderPost();\n" +
                        "    GetHistoryToday(cb_blogId, cb_blogApp, cb_entryCreatedDate);   \n" +
                        "</script>\n" +
                        "</div>\n" +
                        "\n" +
                        "\n" +
                        "</div>\n" +
                        "<div class=\"footer\">\n" +
                        "\n" +
                        "<p id=\"footer\">\n" +
                        "\tPowered by: \n" +
                        "\t<br />\n" +
                        "\t\n" +
                        "\t<a id=\"Footer1_Hyperlink3\" NAME=\"Hyperlink1\" href=\"https://www.cnblogs.com/\" " +
                        "style=\"font-family:Verdana;font-size:12px;\">博客园</a>\n" +
                        "\t<br />\n" +
                        "\tCopyright &copy; ggjucheng\n" +
                        "</p>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>\n";

        String[] res = RegexUtils.findTags(text1,"a");
        for(String line : res) {
            System.out.println(line);
        }
    }
}
