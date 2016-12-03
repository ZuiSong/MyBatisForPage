package principle;

public class PrincipleTest {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		SqlSession sqlSession = new SqlSession();
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		// System.out.println(mapper.deleteUser(4));

		mapper.getInfoById(2);
	}

}