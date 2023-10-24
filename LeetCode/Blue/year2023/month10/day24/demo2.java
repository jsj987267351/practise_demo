package year2023.month10.day24;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/24 16:47
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s = "VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG" +
                "SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF" +
                "ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA" +
                "BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL" +
                "YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH" +
                "ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU" +
                "XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR" +
                "ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG" +
                "MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA" +
                "VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF" +
                "GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC" +
                "EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK" +
                "PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW" +
                "CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP" +
                "RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS" +
                "PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR" +
                "JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL" +
                "YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP" +
                "HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN" +
                "DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF" +
                "LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW" +
                "CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ" +
                "IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI" +
                "ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB" +
                "HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP" +
                "FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS" +
                "VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ" +
                "BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR" +
                "RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY" +
                "ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX";
        char[][] chars = new char[30][50];
        int index = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
                chars[i][j] = s.charAt(index++);
            }
        }
        System.out.println(getSum(chars));
        scan.close();
    }

    public static int getSum(char[][] chars) {
        int res = 0;
        for (int row = 0; row < 30; row++) {
            for (int col = 0; col < 50; col++) {
                char cur = chars[row][col];
                //        同行
                for (int tempCol = col + 1; tempCol < 50; tempCol++) {
                    if (chars[row][tempCol] > cur) res++;
                }
                //        同列
                for (int tempRow = row + 1; tempRow < 30; tempRow++) {
                    if (chars[tempRow][col] > cur) res++;
                }
                //        从左上往右下看
                for (int tempRow = row + 1, tempCol = col + 1; tempRow < 30 && tempCol < 50; tempRow++, tempCol++) {
                    if (chars[tempRow][tempCol] > cur) res++;
                }
                //        从右上往左下看
                for (int tempRow = row + 1, tempCol = col - 1; tempRow < 30 && tempCol >= 0; tempRow++, tempCol--) {
                    if (chars[tempRow][tempCol] > cur) res++;
                }
                //        从左下往右上看
                for (int tempRow = row - 1, tempCol = col + 1; tempRow >= 0 && tempCol < 50; tempRow--, tempCol++) {
                    if (chars[tempRow][tempCol] > cur) res++;
                }
            }
        }
        return res;
    }
}

