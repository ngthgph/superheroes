package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesList(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
    ) {
        items(heroes) {
            HeroItem(
                hero = it,
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_small),
                    )
            )
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.elevation_small))
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium))) {
            HeroInfor(
                nameRes = hero.nameRes,
                descriptionRes = hero.descriptionRes,
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier
                .width(dimensionResource(id = R.dimen.padding_medium)))
            HeroImage(
                imageRes = hero.imageRes,
                nameRes = hero.nameRes
            )
        }
    }
}

@Composable
fun HeroImage(
    @DrawableRes imageRes: Int,
    @StringRes nameRes: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(id = nameRes),
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeroInfor(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.image_size)),
    ) {
        Text(
            text = stringResource(id = nameRes),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(id = descriptionRes),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .weight(1f)
        )
    }
}

//@Preview
//@Composable
//fun HeroItemPreview() {
//    SuperheroesTheme(darkTheme = false) {
//        HeroesList()
//    }
//}
//
//@Preview
//@Composable
//fun HeroItemDarkPreview() {
//    SuperheroesTheme(darkTheme = true) {
//        HeroesList()
//    }
//}