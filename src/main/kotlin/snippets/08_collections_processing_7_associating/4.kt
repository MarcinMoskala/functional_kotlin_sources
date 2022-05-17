package f_08_collections_processing_7_associating.s_4

class Offer(val buyerId: String)
class User(val id: String)
class UserOffer
fun createUserOffer(offer: Offer, user: User?): UserOffer = TODO()

fun produceUserOffers(
    offers: List<Offer>,
    users: List<User>
): List<UserOffer> {
    // 
    val usersById = users.associateBy { it.id }
    return offers
        .map { createUserOffer(it, usersById[it.buyerId]) }
}
