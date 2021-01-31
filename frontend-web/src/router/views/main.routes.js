import Main from "../../views/Main";
import Lotto from "../../components/Lotto";
import Portfolio from "../../components/Portfolio";
import DefaultTabComponent from "../../components/DefaultTabComponent";

export default[
  {
    path: '/main',
    name: 'Main',
    component: Main,
    children: [
      {path: '', component: DefaultTabComponent},
      {path: '/main/lotto', component: Lotto},
      {path: '/main/portfolio', component: Portfolio}
    ]
  }
]