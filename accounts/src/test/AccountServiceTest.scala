import org.scalatest.FunSuite


class AccountServiceTest extends FunSuite {
  val accountService = new AccountService()

  val user: User = User("neha1194", "password1", 9717857184L)


  test("should add user to userList") {
 val x = accountService.addUser(user)
    assert(x === true )
  }
  test("should not add  same user  to userList") {

    assert(accountService.addUser(user) === false)
  }
  val token = accountService.authenticate("neha1194", "password1")
  print(token)


  test("should successfully authenticate user") {
    val x = accountService.authenticate("neha1194", "password1")
    print(x)
    assert(x.equals(token))
  }

  test("should not authenticate user") {

    assert(accountService.authenticate("nimit1194","passwortterdfd").equals("Authentication-Failure"))
  }
}
