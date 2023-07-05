import Title from "./HeaderComponent/ViewTitleComponent/Title";
import Logo from "./HeaderComponent/LogoComponent/Logo";

const HeaderComponent = (props) => {
    return (
        <div>
            <h2>I am Header Component!!</h2>
            <Logo />
            <Title />
        </div>


    );
}

export default HeaderComponent;
