package net.dakimura.text;

/**
 * スキルがユーザに対して行う返答文言をまとめる静的クラス
 *
 * @author dakimura
 */
public class SpeechText {

    private SpeechText() {
    }

    // スキルが起動したとき
    public static final String LAUNCH = "一言リピートにようこそ。セイハロー! のように、セイに続けて短いフレーズを立て続けに言ってください。";

    // 使い方説明、ユーザに発声を促すとき
    public static final String SAY_PHRASE = "セイに続けて短いフレーズを立て続けに言ってください。何も言わないと一言リピートを終了します。";

    // ユーザが言ったフレーズが聞き取れなかったとき
    public static final String SAY_THAT_AGAIN = "すみません、よくわかりませんでした。セイハロー! のように、セイに続けて短いフレーズを立て続けに言ってください。";

    // ユーザが何も発声してくれなかったときの催促
    public static final String REPROMPT = "何も言わないと一言リピートを終了します。";

    // スキル終了時
    public static final String SESSION_END = "一言リピートをストップします。";
}
