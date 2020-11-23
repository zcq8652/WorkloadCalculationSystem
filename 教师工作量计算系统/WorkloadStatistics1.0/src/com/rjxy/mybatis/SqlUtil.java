package com.rjxy.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rjxy.domain.ClassTable;
import com.rjxy.domain.Count;
import com.rjxy.domain.CourseTable;
import com.rjxy.domain.Direction;
import com.rjxy.domain.DutyTable;
import com.rjxy.domain.Equation;
import com.rjxy.domain.Other;
import com.rjxy.domain.PageBean;
import com.rjxy.domain.Parameters;
import com.rjxy.domain.PositionTable;
import com.rjxy.domain.User;



public class SqlUtil {
	private final static String NAMESPACE="mybatis.";
	
	//班级表的增删改查-------------------------------------------------------------------------
	public int insertClassTable(ClassTable classTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertClassTable";
		int a = session.insert(s, classTable);
		session.close();
		return a;
	}
	public int deleteClassTable(ClassTable classTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteClassTable";
		int a = session.delete(s, classTable);
		session.close();
		return a;
	}
	public int updateClassTable(ClassTable classTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateClassTable";
		int a = session.update(s, classTable);
		session.close();
		return a;
	}
	public ClassTable selectClassTable(String classs) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectClassTable";
		ClassTable classTable2 = session.selectOne(s, classs);
		session.close();
		return classTable2;
	}
	public String selectClassTableNumber(String classs) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectClassTableNumber";
		String string = session.selectOne(s, classs);
		session.close();
		return string;
	}
	public List<ClassTable> selectAllClassTable() throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllClassTable";
		List<ClassTable> classTables = session.selectList(s);
		session.close();
		return classTables;
	}
	public List<ClassTable> selectGradeAllClassTable(String grade) throws IOException{//修改过
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectGradeAllClassTable";
		List<ClassTable> classTables = session.selectList(s, grade);
		session.close();
		return classTables;
	}
	//课程表的增删改查-------------------------------------------------------------------------
	public int insertCourseTable(CourseTable courseTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertCourseTable";
		int a = session.insert(s, courseTable);
		session.close();
		return a;
	}
	public int deleteCourseTable(CourseTable courseTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteCourseTable";
		int a = session.delete(s, courseTable);
		session.close();
		return a;
	}
	public int updateCourseTable(CourseTable courseTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateCourseTable";
		int a = session.update(s, courseTable);
		session.close();
		return a;
	}
	public CourseTable selectCourseTable(String courseID) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectCourseTable";
		CourseTable courseTable2 = session.selectOne(s, courseID);
		session.close();
		return courseTable2;
	}
	public List<CourseTable> selectAllCourseTable() throws IOException{//修改过
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllCourseTable";
		List<CourseTable> courseTable = session.selectList(s);
		session.close();
		return courseTable;
	}
	public List<CourseTable> selectAllCourseTableByPage(PageBean pageBean) throws IOException{//鍒嗛〉
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllCourseTableByPage";
		List<CourseTable> courseTable = session.selectList(s,pageBean);
		session.close();
		return courseTable;
	}
	public int getCourseTableRow() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectCourseTableRow";
		int a = session.selectOne(s);
		session.close();
		return a;
	}
	//User表的增删改查-------------------------------------------------------------------------------------------	
	public int insertUser(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertUser";
		int a = session.insert(s, user);
		session.close();
		return a;
	}
	public int deleteUser(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deletetUser";
		int a = session.insert(s, user);
		session.close();
		return a;
	}
	public int updateUser(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateUser";
		int a = session.update(s, user);
		session.close();
		return a;
	}
	public int updateUserPermissions(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateUserPermissions";
		int a = session.update(s, user);
		session.close();
		return a;
	}
	public int updateUserPassword(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateUserPassword";
		int a = session.update(s, user);
		session.close();
		return a;
	}
	public int updateUserStatusOne(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateUserStatusOne";
		int a = session.update(s, user);
		session.close();
		return a;
	}
	public int updateUserStatus(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateUserStatus";
		int a = session.update(s, user);
		session.close();
		return a;
	}
	public User select(User user)throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"getUser";
		User users = session.selectOne(s, user);
		session.close();
		return users;
	}
	public User select_uid(String uid)throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"getUser_uid";
		User user = session.selectOne(s, uid);
		session.close();
		return user;
	}
	public List<User> selectAllUser() throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllUser";
		List<User> users = session.selectList(s);
		session.close();
		return users;
	}
	public List<User> selectAllMajorTeacher(String major) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllMajorTeacher";
		List<User> users = session.selectList(s,major);
		session.close();
		return users;
	}
	public List<User> selectAllStatusTeacher(String status) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllStatusTeacher";
		List<User> users = session.selectList(s,status);
		session.close();
		return users;
	}
	public List<User> selectAllStatusTeacher_major(User user) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllStatusTeacher_major";
		List<User> users = session.selectList(s,user);
		session.close();
		return users;
	}
	public List<User> selectAllStatusTeacher_major2(User user) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllStatusTeacher_major";
		List<User> users = session.selectList(s,user);
		session.close();
		return users;
	}
	public int selectCountAllStatus(String status) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectCountAllStatus";
		int number = session.selectOne(s, status);
		session.close();
		return number;
	}
	public int selectCountAllStatusDirection(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectCountAllStatusDirection";
		int number = session.selectOne(s, user);
		session.close();
		return number;
	}
	public List<String> selectAllName(String status) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllName";
		List<String> nameList = session.selectList(s, status);
		session.close();
		return nameList;
	}
	public List<String> selectAllNameDirection(User user) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllNameDirection";
		List<String> nameList = session.selectList(s, user);
		session.close();
		return nameList;
	}
	public int updateUserMajor(User user) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateUserMajor";
		int number = session.update(s, user);
		session.close();
		return number;
	}
	//counts表的增删改查------------------------------------------------------------------------------------------------------
	public int insertCount(Count count) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertCount";
		int a = session.insert(s, count);
		session.close();
		return a;	
	}
	public int deleteCount(Count count) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteCount";
		int a = session.delete(s, count);
		session.close();
		return a;
	}
	public int deleteCountByOne(Count count) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteCountByOne";
		int a = session.delete(s, count);
		session.close();
		return a;
	}
	public int deleteAllCount(String uid) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteAllCount";
		int a = session.delete(s, uid);
		session.close();
		return a;
	}
	public int updateCount(Count count) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateCount";
		int a = session.update(s, count);
		session.close();
		return a;
	}
	public int updateCountByOne(Count count) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateCountByOne";
		System.out.println(count);
		int a = session.update(s, count);
		session.close();
		return a;
	}
	public Count selectCount (Count count) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"getCount";
		Count counts = session.selectOne(s, count);
		session.close();
		return counts;
	}
	public List<Count> selectAllCount(User user) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllCount";
		List<Count> counts = session.selectList(s,user);
		session.close();
		return counts;
	}
	public double countTime(User user)throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"countTime";
		double times = 0.0;
		try {
			times = session.selectOne(s, user);
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return times;
	}
	//equation表的增删改查
	public int instertEquation(Equation equation) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertEquation";
		int a = session.insert(s, equation);
		session.close();
		return a;	
	}
	public int deleteEquation(Equation equation) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteEquation";
		int a = session.delete(s, equation);
		session.close();
		return a;
	}
	public int updateEquation(Equation equation) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateEquation";
		int a = session.update(s, equation);
		session.close();
		return a;
	}
	public Equation selectEquation(String numberA) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"getEquation";
		Equation equation = session.selectOne(s, numberA);
		session.close();
		return equation;
	}
	public List<Equation> selectAllEquation() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllEquation";
		List<Equation> equation = session.selectList(s);
		session.close();
		return equation;
	}
	//other表的增删改查
	public int insertOther(Other other) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertOther";
		int a = session.insert(s, other);
		session.close();
		return a;
	}
	public int deleteAllOther(String uid) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteAllOther";
		int a = session.delete(s, uid);
		session.close();
		return a;
	}
	public int updateOther(Other other) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateOther";
		int a = session.update(s, other);
		session.close();
		return a;
	}
	public int updateOtherByOne(Other other) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateOtherByOne";
		int a = session.update(s, other);
		session.close();
		return a;
	}
	public List<Other> selectAllOther(User user) throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllOther";
		List<Other> others = session.selectList(s,user);
		session.close();
		return others;
	}
	public Other selectOther(Other other) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectOther";
		Other other2 = session.selectOne(s, other);
		session.close();
		return other2;
	}
	public double countOther(User user)throws IOException{
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"countOther";
		double others = 0.0;
		try {
			others = session.selectOne(s, user);
		} catch (Exception e) {
			
		} finally {
			session.close();
		}				
		return others;
	}
	//parameters表的增删改查
	public int insertParameters(Parameters parameters) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertParameters";
		int a = session.insert(s, parameters);
		session.close();
		return a;
	}
	public int deleteParameters(Parameters parameters) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteParameters";
		int a = session.delete(s, parameters);
		session.close();
		return a;
	}
	public int updateParameters(Parameters parameters) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateParameters";
		int a = session.update(s, parameters);
		session.close();
		return a;
	}
	public Parameters selectParameters(String parametersID) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectParameters";
		Parameters parameters2 = session.selectOne(s,parametersID);
		session.close();
		return parameters2;
	}
	public List<Parameters> selectAllParameters() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllParameters";
		List<Parameters> parameters= session.selectList(s);
		session.close();
		return parameters;
	}
	//dutytable表的增删改查 
	public int insertDutyTable(DutyTable dutyTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertDutyTable";
		int a = session.insert(s, dutyTable);
		session.close();
		return a;
	}
	public int deleteDutyTable(DutyTable dutyTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteDutyTable";
		int a = session.delete(s, dutyTable);
		session.close();
		return a;
	}
	public int updateDutyTable(DutyTable dutyTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateDutyTable";
		int a = session.update(s, dutyTable);
		session.close();
		return a;
	}
	public List<DutyTable> selectAllDutyTable() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllDutyTable";
		List<DutyTable> dutyTables = session.selectOne(s);
		session.close();
		return dutyTables;
	}
	public DutyTable selectDutyTable(DutyTable dutyTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectDutyTable";
		DutyTable dutyTables = session.selectOne(s, dutyTable);
		session.close();
		return dutyTables;
	}
	//positiontable表的增删改查
	public int getPositionTableRow() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectPositionTableRow";
		int a = session.selectOne(s);
		session.close();
		return a;
	}
	public int insertPositionTable(PositionTable positionTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertPositionTable";
		int a = session.insert(s, positionTable);
		session.close();
		return a;
	}
	public int deletePositionTable(PositionTable positionTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deletePositionTable";
		int a = session.delete(s, positionTable);
		session.close();
		return a;
	}
	public int updatePositionTable(PositionTable positionTable) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updatePositionTable";
		int a = session.update(s, positionTable);
		session.close();
		return a;
	}
	public List<PositionTable> selectAllPositionTable() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllPositionTable";
		List<PositionTable> positionTables = session.selectList(s);
		session.close();
		return positionTables;
	}
	public List<PositionTable> selectAllPositionTableByPage(PageBean pageBean) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllPositionTableByPage";
		List<PositionTable> positionTables = session.selectList(s, pageBean);
		session.close();
		return positionTables;
	}
	public PositionTable selectPositionTable(String positionID) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectPositionTable";
		PositionTable positionTable2 = session.selectOne(s, positionID);
		session.close();
		return positionTable2;
	}
	
	//Direction表的增删改查
	public int insertDirection(Direction direction) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"insertDirection";
		int a = session.insert(s, direction);
		session.close();
		return a;
	}
	public int deleteDirection(Direction direction) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"deleteDirection";
		int a = session.delete(s, direction);
		session.close();
		return a;
	}
	public int updateDirection(Direction direction) throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"updateDirection";
		int a = session.update(s, direction);
		session.close();
		return a;
	}
	public List<Direction> selectAllDirection() throws IOException {
		SqlSession session = MyBatisUtil.sqlSession();
		String s = NAMESPACE+"selectAllDirection";
		List<Direction> directions = session.selectList(s);
		session.close();
		return directions;
	}
	
	
	
	
	
	
	
	
	
	
	
}
