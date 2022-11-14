import NotificationButton from "./components/notificationButton"
import Header from "./components/header"
import SalesCard from "./components/salesCard"

function App() {
  return (
    //<></> usando fragment para o componente exportar mais de uma tag
    <>
      <Header></Header>
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard></SalesCard>
          </div>

        </section>
      </main>
    </>
  )

}

export default App
