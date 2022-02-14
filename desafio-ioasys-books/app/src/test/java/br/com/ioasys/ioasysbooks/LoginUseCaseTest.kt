package br.com.ioasys.ioasysbooks

import br.com.ioasys.ioasysbooks.domain.exception.InvalidPasswordException
import br.com.ioasys.ioasysbooks.domain.model.User
import br.com.ioasys.ioasysbooks.domain.repositories.LoginRepository
import br.com.ioasys.ioasysbooks.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class LoginUseCaseTest {

    @Mock
    private lateinit var repository: LoginRepository
    private lateinit var subject: LoginUseCase

    private val userFake = User(
        name = "Sara",
        birthdate = "17/04/1997",
        gender = "A",
        accessToken = "Token",
        id = "id"
    )

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        subject = LoginUseCase(
            loginRepository = repository,
            scope = CoroutineScope(Dispatchers.IO)
        )
    }

    @Test
    fun `WHEN SUCCESS MUST RETURN USER`() = runBlocking {
        stubOnSuccess()
        subject.run(
            params = LoginUseCase.Params(
                email = "email",
                password = "1234"
            )
        ).collect {
            assert(it == userFake)
        }
    }

    @Test(expected = InvalidPasswordException::class)
    fun `WHEN EMPTY PASSWORD MUST RETURN INVALIDEMAILEXCEPTION`() {
        subject.run(
            params = LoginUseCase.Params(
                email = "sara@email.com",
                password = ""
            )
        )
    }

    private fun stubOnSuccess() {
        whenever(
            repository.login(
                email = any(),
                password = any()
            )
        ).thenAnswer {
            flowOf(userFake)
        }
    }
}