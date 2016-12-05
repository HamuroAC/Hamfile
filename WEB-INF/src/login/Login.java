package login;

/**
 * ログイン処理の抽象クラス
 */
public abstract class Login {

    /**
     * 指定されたIDとパスワードに紐づくユーザ情報を返却.
     *
     * @param id	ID
     * @param pass	パスワード
     * @return ユーザ情報
     */
    public abstract LoginUserBean getUserData(String id, String password);
}