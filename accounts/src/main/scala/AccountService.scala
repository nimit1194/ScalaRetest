import scala.collection.mutable
import org.mindrot.jbcrypt.BCrypt

class AccountService {

  var listOfUser: mutable.Map[Long, User] = mutable.Map[Long, User]()

  def addUser (user: User): Boolean = {
    val data = listOfUser.map(data => data._1 == user.mobileNo)

    if (data.isEmpty || listOfUser.isEmpty) {
      listOfUser += (user.mobileNo -> user)
      true
    }
    else {
      false
    }
  }

  def authenticate (userName: String, password: String): String = {

    val users = listOfUser.filter(info => info._2.userName == userName && info._2.password == password)

    if (users.isEmpty){ "Authentication-Failure"}
    else {
      val token = BCrypt.hashpw(password, BCrypt.gensalt())
      token
    }

  }
}
object AccountService extends App{
  val user: User = User("nimit1194", "password", 9717857154L)

  val acc = new AccountService()
  acc.addUser(user)
  print(acc.authenticate("nimit1194", "password"))
  print(acc.listOfUser)
}
