package signup;

/**
 * ログイン処理クラス.
 * 今回は親クラスとして使用.
 * SignupDB.java 継承用
 */
public class Signup {
	/**
	 * 指定されたIDとパスワードに紐づくユーザ情報を返却します.
	 * @param id	ID
	 * @param pass	パスワード
	 * @return ユーザ情報
	 */
	public SignupUserBean getUserData(String id, String password) {
		SignupUserBean bean = new SignupUserBean();
		
		// 引数のIDとパスワードを判定
		if(id.equals("") || password.equals("")) {
			bean.setId(id);
			
		} else {

			bean = null;
		}
		return bean;
	}
}