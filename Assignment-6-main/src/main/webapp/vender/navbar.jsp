<%@include file="user_is_online.jsp" %>

<div class="" style="background-color:rgba(14,16,221,0.89)">

    <div class="container p-2">
        <div class="row">
            <%
                if (!online) {

            %>
            <div class="col">
                <h5>
                    <a href="/" class="navbar-brand" style="color: white">
                        <img src="" width="25" height="25" class="d-inline-block align-top" alt="" loading="lazy">
                        mikas.kz</a>
                </h5>
            </div>

            <div class="col">
                <h6 class="float-right mr-3" style="color: white">
                    <a href="" style="color: white">
                        <img src="https://airshp.com/wp-content/uploads/AL1-LogoSuite2016-v3_MARK.png" width="25"
                             height="25" class="d-inline-block align-top"
                             alt="" loading="lazy">
                        About mikas.kz
                    </a>
                </h6>

                <h6 class="float-right mr-3">
                    <a href="/faq" style="color: white">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-question-octagon"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1L1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z"/>
                            <path d="M5.255 5.786a.237.237 0 0 0 .241.247h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286zm1.557 5.763c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z"/>
                        </svg>
                        FAQ
                    </a>
                </h6>
                <h6 class="float-right mr-3">
                    <a href="/" style="color: white">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-box-arrow-in-right"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
                            <path fill-rule="evenodd"
                                  d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                        </svg>
                        Login
                    </a>
                </h6>
                <h6 class="float-right mr-3">
                    <a href="/registration" style="color: white">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-plus-fill"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm7.5-3a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                        </svg>
                        Register
                    </a>
                </h6>
            </div>
            <%
            } else {
            %>
            <div class="col-4">
                <h5>
                    <a href="/" class="navbar-brand" style="color: white">
                        <img src="https://airshp.com/wp-content/uploads/AL1-LogoSuite2016-v3_MARK.png" width="25" height="25" class="d-inline-block align-top"
                             alt="" loading="lazy">
                        mikas.kz</a>
                </h5>

            </div>
            <%
                }
            %>
        </div>
    </div>
</div>