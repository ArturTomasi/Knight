
function onLoginError()
{
    $( 'input' ).val( "" ).first().focus();

    $( '.login-center' ).effect( "bounce", "swith", function()
    {
        $( '.error-login' ).show( 'fade' );

        setTimeout( function()
        {
          $( '.error-login' ).hide( 'fade' );
        }, 3000 );
    } );
}