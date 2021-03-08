import BandMain from "../../views/band/BandMain";
import TokenCallback from "../../views/band/TokenCallback";

export default[
  {
    path:'/band/main',
    name: 'bandMain',
    component: BandMain
  },
  {
    path: '/band/token',
    name: 'bandCallback',
    component: TokenCallback
  }
]