package login;

/**
 * ログイン処理クラス.
 * 今回は親クラスとして使用.
 * LoginDB.java 継承用
 */
public class Login {
	/**
	 * 指定されたIDとパスワードに紐づくユーザ情報を返却します.
	 * @param id	ID
	 * @param pass	パスワード
	 * @return ユーザ情報
	 */
	public LoginUserBean getUserData(String id, String name) {
		LoginUserBean bean = new LoginUserBean();
		
		// 引数のIDとパスワードを判定
		if("web01".equals(id) && "name".equals(name)) {		
			// IDがweb01の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("すく太郎");	
		} else if ("web02".equals(id) && "name".equals(name)) {
			// IDがweb02の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("すく次郎");
			
		} else {
			// IDが合致しない場合はnullを代入
			bean = null;
		}
		return bean;
	}
}