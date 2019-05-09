package com.wjn.viewlistdemo.activity.textview;

public class StringUtils {

    public static String string1 = "我们不想看到以赛亚-托马斯受伤。向他这一个不可思议的赛季致敬，他今年所完成的事情，以及在他妹妹不幸去世的情况下，他在季后赛中所做的事情。但是，对于我们一个整体而言，我们面对的从来都不只是一个人。这不是我们关注的焦点。这一直都是团队的努力，以及我们如何能够拿出最好的比赛计划来对抗他们的球队。他们仍然很好地执行教练意图。他们仍然有一些球员会去迎接挑战，会站出来，所以我们必须为此做好准备。”我们不想看到以赛亚-托马斯受伤。向他这一个不可思议的赛季致敬，他今年所完成的事情，以及在他妹妹不幸去世的情况下，他在季后赛中所做的事情。但是，对于我们一个整体而言，我们面对的从来都不只是一个人。这不是我们关注的焦点。这一直都是团队的努力，以及我们如何能够拿出最好的比赛计划来对抗他们的球队。他们仍然很好地执行教练意图。他们仍然有一些球员会去迎接挑战，会站出来，所以我们必须为此做好准备。”“我们不想看到以赛亚-托马斯受伤。向他这一个不可思议的赛季致敬，他今年所完成的事情，以及在他妹妹不幸去世的情况下，他在季后赛中所做的事情。但是，对于我们一个整体而言，我们面对的从来都不只是一个人。这不是我们关注的焦点。这一直都是团队的努力，以及我们如何能够拿出最好的比赛计划来对抗他们的球队。他们仍然很好地执行教练意图。他们仍然有一些球员会去迎接挑战，会站出来，所以我们必须为此做好准备。”";

    public static String string2="我爱鲁能泰山队";

    /**
     * 格式化字符串，每三位用逗号隔开
     *
     * @param str
     * @return
     */
    public static String addComma(String str) {
        str = new StringBuilder(str).reverse().toString();     //先将字符串颠倒顺序
        if (str.equals("0")) {
            return str;
        }
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (i * 3 + 3 > str.length()) {
                str2 += str.substring(i * 3, str.length());
                break;
            }
            str2 += str.substring(i * 3, i * 3 + 3) + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        //最后再将顺序反转过来
        String temp = new StringBuilder(str2).reverse().toString();
        //将最后的,去掉
        return temp.substring(0, temp.lastIndexOf(",")) + temp.substring(temp.lastIndexOf(",") + 1, temp.length());
    }

}
