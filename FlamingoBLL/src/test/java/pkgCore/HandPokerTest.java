package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void RoyalFlush_Test() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.RoyalFlush, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(eRank.TEN, hsp.getLoCard().geteRank());
	}
	
	@Test
	public void StraightFlush_Test1() {
	
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.StraightFlush, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertEquals(eRank.ACE, hsp.getLoCard().geteRank());
	}

	@Test
	public void StraightFlush_Test2() {
	
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.SIX));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.StraightFlush, hsp.geteHandStrength());
		assertEquals(eRank.SIX, hsp.getHiCard().geteRank());
		assertEquals(eRank.TWO, hsp.getLoCard().geteRank());

	}
	@Test
	public void FourOfAKind_Test1() {
	
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FourOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 1);
	}
	@Test
	public void FourOfAKind_Test2() {
	
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FourOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.TWO, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 1);
	}

	@Test
	public void FullHouse_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());
		assertEquals(eRank.TEN, hsp.getHiCard().geteRank());
		assertEquals(eRank.EIGHT, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 0);
		
		
	}
	
	@Test
	public void FullHouse_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());
		assertEquals(eRank.EIGHT, hsp.getHiCard().geteRank());
		assertEquals(eRank.TEN, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 0);
		
		
	}
	
	@Test
	public void Flush_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Flush, hsp.geteHandStrength());
		assertTrue(hsp.getKickers().size() == 5);
		
		
	}
	
	@Test
	public void Flush_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Flush, hsp.geteHandStrength());
		assertTrue(hsp.getKickers().size() == 5);
		
		
	}
	
	@Test
	public void Straight_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertEquals(eRank.ACE, hsp.getLoCard().geteRank());
		
	}
	
	@Test
	public void Straight_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(eRank.TEN, hsp.getLoCard().geteRank());
		
		
	}
	
	public void ThreeOfKind_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.ThreeOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.TWO, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 2);
	}
	
	@Test
	public void ThreeOfKind_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.ThreeOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.QUEEN, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 2);
	}
	
	
	@Test
	public void TwoPair_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.TwoPair, hsp.geteHandStrength());
		assertEquals(eRank.FOUR, hsp.getHiCard().geteRank());
		assertEquals(eRank.TWO, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 1);
	}
	
	@Test
	public void TwoPair_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.TwoPair, hsp.geteHandStrength());
		assertEquals(eRank.KING, hsp.getHiCard().geteRank());
		assertEquals(eRank.TEN, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 1);
	}
	
	@Test
	public void Pair_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Pair, hsp.geteHandStrength());
		assertEquals(eRank.TWO, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 3);
		
	}
	
	@Test
	public void Pair_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Pair, hsp.geteHandStrength());
		assertEquals(eRank.JACK, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 3);
	}
	
	@Test
	public void HighCard_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 5);
		
	}
	
	@Test
	public void HighCard_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.TEN, hsp.getHiCard().geteRank());
		assertTrue(hsp.getKickers().size() == 5);
	}
	
}
